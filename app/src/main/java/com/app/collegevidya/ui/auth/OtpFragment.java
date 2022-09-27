package com.app.collegevidya.ui.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.collegevidya.data.viewmodel.OtpViewModel;
import com.app.collegevidya.databinding.FragmentOtpBinding;
import com.app.collegevidya.ui.HomeActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

public class OtpFragment extends Fragment {
    private static final Long TIMER_VALUE = 30l;
    private final String message = "";
    FragmentOtpBinding binding;
    private OtpViewModel otpViewModel;
    private Context mContext;

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init ViewModel
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOtpBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.otpView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 4) {
                    Intent authActivity = new Intent(mContext, HomeActivity.class);
                    startActivity(authActivity);
                    getActivity().finish();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.btnBack.setOnClickListener(view1 -> Navigation.findNavController(view1).popBackStack());
        binding.btnEdit.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());
        // Otp Counter And Resending
        binding.otpCount.setOnClickListener(v -> {
            startOtpTimer();
            Toast.makeText(mContext, "Resending Otp", Toast.LENGTH_SHORT).show();
        });
    }

    //This Function Will Create Otp Counter
    public void startOtpTimer() {
        //Creating Timer For Otp
        binding.otpCount.setClickable(false);
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(x -> {
                    // update your view here
                    binding.otpCount.setText(String.valueOf(TIMER_VALUE - x));
                })
                .takeUntil(aLong -> aLong == TIMER_VALUE)
                .doOnComplete(() -> {
                            //After Timer
                            binding.otpCount.setText("Resend");
                            binding.otpCount.setClickable(true);
                        }
                ).subscribe();

    }

}