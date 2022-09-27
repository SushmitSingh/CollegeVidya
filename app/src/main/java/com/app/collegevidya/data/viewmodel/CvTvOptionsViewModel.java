package com.app.collegevidya.data.viewmodel;

import android.view.View;
import androidx.databinding.ObservableField;
import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.data.model.CvTvOptionModel;

public class CvTvOptionsViewModel {

    private final CvTvOptionModel cvTvOptionModel;
    private final CvTvOptionClickListener cvTvOptionClickListener;

    public final ObservableField<String> option;

    public CvTvOptionsViewModel(CvTvOptionModel cvTvOptionModel, CvTvOptionClickListener cvTvOptionClickListener) {
        this.cvTvOptionModel = cvTvOptionModel;
        this.cvTvOptionClickListener = cvTvOptionClickListener;

        option = new ObservableField<>(cvTvOptionModel.getOption());

    }

    public void onItemClick(View view) {
        cvTvOptionClickListener.onItemClick(view, cvTvOptionModel );
    }

    public interface CvTvOptionClickListener extends BaseItemListener<CvTvOptionModel> {
        // to be implemented by the adapter.
    }
}
