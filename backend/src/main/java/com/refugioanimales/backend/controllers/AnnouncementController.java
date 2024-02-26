package com.refugioanimales.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.refugioanimales.persistence.AnnouncementRepository;

import com.refugioanimales.persistence.Announcement;
import com.refugioanimales.persistence.AnnouncementRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AnnouncementController {

    private Announcement repository;

    public AnnouncementController(@Autowired AnnouncementRepository repository) {
        this.repository = (Announcement) repository;
    }

    @GetMapping("/announcement")
    public List<AnnouncementResponse> showAnnouncement() {
        List<AnnouncementResponse> announcementResponse = new ArrayList<AnnouncementResponse>();
        List<Announcement> announcementInDataBaseAnnouncement = repository.findAll();
        for (Announcement announcement : announcementInDataBaseAnnouncement) {
            announcementResponse.add(new AnnouncementResponse(
                announcement.getId(),
                announcement.getTitle(),
                announcement.getDescription(),
                announcement.getLocalization(),
                announcement.getImageUrl()));
        }
        return announcementResponse;
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementResponse> getAnnouncementById(@PathVariable Integer id) {
        Optional<Announcement> optionalAnnouncement = repository.findById(id);
        if (optionalAnnouncement.isPresent()) {
            Announcement announcement = optionalAnnouncement.get();
            AnnouncementResponse response = new AnnouncementResponse(
                announcement.getId(),
                announcement.getTitle(),
                announcement.getDescription(),
                announcement.getLocalization(),
                announcement.getImageUrl());
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/announcement")
    public AnnouncementResponse createAnnouncement(@RequestBody AnnouncementRequest request) {
        Announcement announcement = new Announcement(
                request.getId(),
                request.getTitle(),
                request.getDescription(),
                request.getLocalization(),
                request.getImageUrl());

        Announcement savedAnnouncement = repository.save(announcement);

        return new AnnouncementResponse(
                savedAnnouncement.getId(),
                savedAnnouncement.getTitle(),
                savedAnnouncement.getDescription(),
                savedAnnouncement.getLocalization(),
                savedAnnouncement.getImageUrl());

    }

    @DeleteMapping("announcement/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnnouncementById(@PathVariable Integer id) {
        Optional<Announcement> optionalAnnouncement = repository.findById(id);
        if (optionalAnnouncement.isPresent()) {
            repository.delete(optionalAnnouncement.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Announcement not found");
        }
    }

    

    @PutMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementResponse> updateAnnouncement(@PathVariable Integer id, @RequestBody AnnouncementRequest updateAnnouncement) {
    Optional<Announcement> optionalAnnouncement = repository.findById(id);
    if (optionalAnnouncement.isPresent()) {
                Announcement existingAnnouncement = optionalAnnouncement.get();
                existingAnnouncement.setTitle(updateAnnouncement.getTitle());
                existingAnnouncement.setDescription(updateAnnouncement.getDescription());
                existingAnnouncement.setLocalization(updateAnnouncement.getLocalization());
                existingAnnouncement.setImageUrl(updateAnnouncement.getImageUrl());


        Announcement updatedAnnouncement = repository.save(existingAnnouncement);

        AnnouncementResponse announcementResponse = new AnnouncementResponse(
                updatedAnnouncement.getId(),
                updatedAnnouncement.getTitle(),
                updatedAnnouncement.getDescription(),
                updatedAnnouncement.getLocalization(),
                updatedAnnouncement.getImageUrl());

        return ResponseEntity.ok().body(announcementResponse);
    } else {
        return ResponseEntity.notFound().build();
    }
}


}