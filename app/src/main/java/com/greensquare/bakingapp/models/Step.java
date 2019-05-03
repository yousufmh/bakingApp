package com.greensquare.bakingapp.models;

public class Step {

    private int id;
    private String shortDescription;
    private String videoURL;
    private String thumbnailURL;

    public Step() {
        this.id = 0;
        this.shortDescription = "";
        this.videoURL = "";
        this.thumbnailURL = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
