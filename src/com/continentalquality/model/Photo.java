package com.continentalquality.model;

public class Photo {

    private int photoId;
    private String photoPartNumber;
    private String photoFileName;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPartNumber() {
        return photoPartNumber;
    }

    public void setPhotoPartNumber(String photoPartNumber) {
        this.photoPartNumber = photoPartNumber;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
}
