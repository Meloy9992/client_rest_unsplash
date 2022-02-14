package com.example.clientTest.model;

public class Image {

    private String id;
    private int width;
    private int height;
    private String description;
    private String altDescription;
    private String urlRaw;
    private String urlFull;

    public Image() {
    }

    public Image(String id, int width, int height, String description, String altDescription, String urlRaw, String urlFull) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.description = description;
        this.altDescription = altDescription;
        this.urlRaw = urlRaw;
        this.urlFull = urlFull;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public String getUrlRaw() {
        return urlRaw;
    }

    public void setUrlRaw(String urlRaw) {
        this.urlRaw = urlRaw;
    }

    public String getUrlFull() {
        return urlFull;
    }

    public void setUrlFull(String urlFull) {
        this.urlFull = urlFull;
    }
}
