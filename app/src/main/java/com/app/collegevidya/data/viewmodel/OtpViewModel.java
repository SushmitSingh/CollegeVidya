package com.app.collegevidya.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.app.collegevidya.data.model.OtpModel;

public class OtpViewModel extends ViewModel {
    private final String sampleRight = "1234";
    private final String successMessage = "Login successful";
    private final String errorMessage = "Enter Valid Otp";
    private final OtpModel model;

    private String toastMessage = null;

    public OtpViewModel() {

        // instantiating object of
        // model class
        model = new OtpModel("");
    }

    public String getUserOtp() {
        return model.getOtp();
    }

    public void setUserOtp(String otp) {
        model.setOtp(otp);
    }

    public void onOtpFilled() {
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    private void setToastMessage(String successMessage) {
        this.toastMessage = toastMessage;
    }

    public boolean isValid() {
        return getUserOtp().equals(sampleRight);
    }


}
