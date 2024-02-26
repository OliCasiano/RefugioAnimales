package com.refugioanimales.backend.controllers;

public class AnnouncementResponse {
    
    private Integer id;
    private String title;
    private String description;
    private String localization;
    private String imageUrl;
    
    public AnnouncementResponse(Integer id, String title, String description, String localization, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.localization = localization;
        this.imageUrl = imageUrl;
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
    
}
