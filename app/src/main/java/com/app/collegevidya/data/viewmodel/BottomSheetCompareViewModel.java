package com.app.collegevidya.data.viewmodel;

import android.view.View;

import androidx.databinding.ObservableField;

import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.data.model.CompareQuizModel;

public class BottomSheetCompareViewModel {

    public final ObservableField<String> quiz;
    private final CompareQuizModel compareQuizModel;
    private final BottomSheetQuizItemClickListener bottomSheetQuizItemClickListener;

    public BottomSheetCompareViewModel(CompareQuizModel compareQuizModel, BottomSheetQuizItemClickListener bottomSheetQuizItemClickListener) {
        this.compareQuizModel = compareQuizModel;
        this.bottomSheetQuizItemClickListener = bottomSheetQuizItemClickListener;

        quiz = new ObservableField<>(compareQuizModel.getQuiz());
    }

    public void onItemClick(View view) {
        bottomSheetQuizItemClickListener.onItemClick(view, compareQuizModel );
    }

    public interface BottomSheetQuizItemClickListener extends BaseItemListener<CompareQuizModel> {
        //
    }

}
