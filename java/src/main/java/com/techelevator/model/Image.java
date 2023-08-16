package com.techelevator.model;

public class Image {
    private int imageId;
    private String imageName;
    private String imageData;

    public Image(int imageId, String imageName, String imageData){
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageData = imageData;
    }

    public Image() {

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

    public String getImageData() { return imageData;}

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }
}
