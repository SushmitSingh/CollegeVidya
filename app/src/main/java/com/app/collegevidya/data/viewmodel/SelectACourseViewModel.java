package com.app.collegevidya.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.model.CourseDetailModel;

public class SelectACourseViewModel extends ViewModel {

    public String imgUrl, courseName, courseCount;

    public SelectACourseViewModel() {

    }

    public SelectACourseViewModel(CourseDetailModel courseDetailModel) {
        this.imgUrl = imgUrl;
        this.courseName = courseName;
        this.courseCount = courseCount;
    }
}
