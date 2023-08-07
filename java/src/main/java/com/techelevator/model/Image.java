package com.techelevator.model;

public class Image {
    private int imageId;
    private String imageName;
    private int imageData;

    public Image(int imageId, String imageName, int imageData){
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageData = imageData;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImageData() {
        return imageData;
    }

    public void setImageData(int imageData) {
        this.imageData = imageData;
    }
}
