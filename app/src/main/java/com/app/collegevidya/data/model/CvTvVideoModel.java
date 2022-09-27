package com.app.collegevidya.data.model;

public class CvTvVideoModel {
    private String url, topic;

    public CvTvVideoModel(String url, String topic) {
        this.url = url;
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
