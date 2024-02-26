package com.refugioanimales.persistence;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

    
    @Entity  
    @Table(name = "announcement")
    public class Announcement {

        @id
        @generatedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String title;
    private String description;
    private String localization;
    private String imageUrl;

    public Announcement(Integer id, String title, String description, String localization, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.localization = localization;
        this.imageUrl = imageUrl;
    }

    public Announcement() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Announcement> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Optional<Announcement> findById(Integer id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Announcement save(Announcement announcement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public void delete(Announcement announcement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}


