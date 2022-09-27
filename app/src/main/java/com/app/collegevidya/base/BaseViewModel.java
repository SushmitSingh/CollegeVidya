package com.app.collegevidya.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.network.DataRepository;

public abstract class BaseViewModel extends ViewModel {

    private final DataRepository dataRepository;
    private final MutableLiveData<Boolean> isLoading;

    public BaseViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        isLoading = new MutableLiveData<>(true);
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.setValue(isLoading);
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }

}
