package com.app.collegevidya.data.model;

public class CourseDetailModel {
    private String imgUrl, courseName, courseCount;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(String courseCount) {
        this.courseCount = courseCount;
    }

    public CourseDetailModel(String imgUrl, String courseName, String courseCount) {
        this.imgUrl = imgUrl;
        this.courseName = courseName;
        this.courseCount = courseCount;
    }
}
