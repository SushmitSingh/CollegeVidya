package com.app.collegevidya.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.model.DashboardFeaturesModel;

public class DashBoardFeaturesViewModel extends ViewModel {
    public String feImage, feColor, feTextColor, feText;

    public DashBoardFeaturesViewModel() {

    }

    public DashBoardFeaturesViewModel(DashboardFeaturesModel dashboardFeaturesModel) {
        this.feImage = feImage;
        this.feColor = feColor;
        this.feTextColor = feTextColor;
        this.feText = feText;
    }
}
