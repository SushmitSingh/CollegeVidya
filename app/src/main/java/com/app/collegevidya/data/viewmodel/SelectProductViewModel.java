package com.app.collegevidya.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.model.SelectProductModel;

public class SelectProductViewModel extends ViewModel {
    public String backImage, descText, descNumber;

    public SelectProductViewModel() {

    }

    public SelectProductViewModel(SelectProductModel selectProductModel) {
        this.backImage = backImage;
        this.descText = descText;
        this.descNumber = descNumber;
    }
}
