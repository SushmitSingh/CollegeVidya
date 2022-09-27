package com.app.collegevidya.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.model.OverviewModel;

public class OverviewViewModel extends ViewModel {
    public String oImage, oText, oDesc, oColor;

    public OverviewViewModel() {
    }

    public OverviewViewModel(OverviewModel overviewModel) {
        this.oImage = oImage;
        this.oText = oText;
        this.oDesc = oDesc;
        this.oColor = oColor;
    }
}
