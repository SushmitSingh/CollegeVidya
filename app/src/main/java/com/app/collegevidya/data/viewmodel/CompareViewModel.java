package com.app.collegevidya.data.viewmodel;

import android.view.View;

import androidx.databinding.ObservableField;

import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.data.model.CompareModel;

public class CompareViewModel {

    private final CompareModel compareModel;
    private final CompareViewModel.CompareClickListner compareClickListner;

    public final ObservableField<String> comImage;
    public final ObservableField<String> comFees;
    public final ObservableField<String> comRating;
    public final ObservableField<String> comPros;
    public final ObservableField<String> comCons;


    public CompareViewModel(CompareModel compareModel, CompareClickListner compareClickListner) {
        this.compareModel = compareModel;
        this.compareClickListner = compareClickListner;

        comImage = new ObservableField<>(compareModel.getComImage());
        comFees = new ObservableField<>(compareModel.getComFees());
        comRating = new ObservableField<>(compareModel.getComRating());
        comPros = new ObservableField<>(compareModel.getComPros());
        comCons = new ObservableField<>(compareModel.getComCons());
    }

    public void onItemClick(View view) {
        compareClickListner.onItemClick(view, compareModel.getComPros());
    }


    public interface CompareClickListner extends BaseItemListener<String> {
        // to be implemented by the adapter.
    }
}
