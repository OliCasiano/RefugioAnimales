package com.refugioanimales.persistence;
import com.refugioanimales.persistence.AnnouncementRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}
