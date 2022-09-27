package com.app.collegevidya.data.model;

public class CompareModel {
    private String comImage, comFees, comRating, comPros, comCons;

    public String getComImage() {
        return comImage;
    }

    public void setComImage(String comImage) {
        this.comImage = comImage;
    }

    public String getComFees() {
        return comFees;
    }

    public void setComFees(String comFees) {
        this.comFees = comFees;
    }

    public String getComRating() {
        return comRating;
    }

    public void setComRating(String comRating) {
        this.comRating = comRating;
    }

    public String getComPros() {
        return comPros;
    }

    public void setComPros(String comPros) {
        this.comPros = comPros;
    }

    public String getComCons() {
        return comCons;
    }

    public void setComCons(String comCons) {
        this.comCons = comCons;
    }

    public CompareModel(String comImage, String comFees, String comRating, String comPros, String comCons) {
        this.comImage = comImage;
        this.comFees = comFees;
        this.comRating = comRating;
        this.comPros = comPros;
        this.comCons = comCons;
    }
}
