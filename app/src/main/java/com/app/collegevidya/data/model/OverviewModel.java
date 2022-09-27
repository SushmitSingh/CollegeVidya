package com.app.collegevidya.data.model;

public class OverviewModel {
    private String oImage, oText, oDesc, oColor;

    public OverviewModel(String oImage, String oText, String oDesc, String oColor) {
        this.oImage = oImage;
        this.oText = oText;
        this.oDesc = oDesc;
        this.oColor = oColor;
    }

    public String getoColor() {
        return oColor;
    }

    public void setoColor(String oColor) {
        this.oColor = oColor;
    }

    public String getoImage() {
        return oImage;
    }

    public void setoImage(String oImage) {
        this.oImage = oImage;
    }

    public String getoText() {
        return oText;
    }

    public void setoText(String oText) {
        this.oText = oText;
    }

    public String getoDesc() {
        return oDesc;
    }

    public void setoDesc(String oDesc) {
        this.oDesc = oDesc;
    }
}
