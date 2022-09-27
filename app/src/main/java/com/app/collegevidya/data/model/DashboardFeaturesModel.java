package com.app.collegevidya.data.model;

public class DashboardFeaturesModel {
    private String feImage, feColor, feTextColor, feText;

    public DashboardFeaturesModel(String feImage, String feColor, String feTextColor, String feText) {
        this.feImage = feImage;
        this.feColor = feColor;
        this.feTextColor = feTextColor;
        this.feText = feText;
    }

    public String getFeImage() {
        return feImage;
    }

    public void setFeImage(String feImage) {
        this.feImage = feImage;
    }

    public String getFeColor() {
        return feColor;
    }

    public void setFeColor(String feColor) {
        this.feColor = feColor;
    }

    public String getFeTextColor() {
        return feTextColor;
    }

    public void setFeTextColor(String feTextColor) {
        this.feTextColor = feTextColor;
    }

    public String getFeText() {
        return feText;
    }

    public void setFeText(String feText) {
        this.feText = feText;
    }
}
