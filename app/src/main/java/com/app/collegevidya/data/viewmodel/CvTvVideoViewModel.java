package com.app.collegevidya.data.viewmodel;

import android.view.View;

import androidx.databinding.ObservableField;

import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.data.model.CvTvVideoModel;

public class CvTvVideoViewModel {
    private final CvTvVideoModel cvTvVideoModel;
    private final CvTvVideoClickListener cvTvVideoClickListener;

    public final ObservableField<String> url;
    public final ObservableField<String> topic;

    public CvTvVideoViewModel(CvTvVideoModel cvTvVideoModel, CvTvVideoClickListener cvTvVideoClickListener) {
        this.cvTvVideoClickListener = cvTvVideoClickListener;
        this.cvTvVideoModel = cvTvVideoModel;

        topic = new ObservableField<>(cvTvVideoModel.getTopic());
        url = new ObservableField<>(cvTvVideoModel.getUrl());

    }

    public void onItemClick(View view) {
        cvTvVideoClickListener.onItemClick(view, cvTvVideoModel.getUrl());
    }


    public interface CvTvVideoClickListener extends BaseItemListener<String> {
        // to be implemented by the adapter.
    }


}
