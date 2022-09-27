package com.app.collegevidya.data.model;

public class SelectProductModel {
    private String backImage, descText, descNumber;

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
    }

    public String getDescNumber() {
        return descNumber;
    }

    public void setDescNumber(String descNumber) {
        this.descNumber = descNumber;
    }

    public SelectProductModel(String backImage, String descText, String descNumber) {
        this.backImage = backImage;
        this.descText = descText;
        this.descNumber = descNumber;
    }
}
