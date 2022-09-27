package com.app.collegevidya.ui.auth;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.collegevidya.R;
import com.app.collegevidya.databinding.FragmentLoginWithNumberBinding;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.api.ApiException;

public class LoginWithNumberFragment extends Fragment {

    private static final int CREDENTIAL_PICKER_REQUEST = 120;
    private FragmentLoginWithNumberBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        phoneHint();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Open Hint Box
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginWithNumberBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnContinue.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_loginWithNumberFragment_to_otpFragment));

        binding.tvMobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==10){
                    Navigation.findNavController(view).navigate(R.id.action_loginWithNumberFragment_to_otpFragment);
                    binding.tvMobileNumber.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void phoneHint() {
      /*  //new
        GetPhoneNumberHintIntentRequest request = GetPhoneNumberHintIntentRequest.builder().build();

        ActivityResultLauncher phoneNumberHintIntentResultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        (ActivityResultCallback<ActivityResult>) result -> {
                            try {
                                String phoneNumber = Identity.getSignInClient(this.getActivity()).getPhoneNumberFromIntent(result.getData());
                                binding.tvMobileNumber.setText(phoneNumber.substring(3));
                            } catch (ApiException e) {
                                e.printStackTrace();
                            }
                        });

        Identity.getSignInClient(this.getActivity())
                .getPhoneNumberHintIntent(request)
                .addOnSuccessListener( result -> {
                    try {
                        phoneNumberHintIntentResultLauncher.launch(result.getIntentSender());
                    } catch(Exception e) {
                        Log.e(TAG, "Launching the PendingIntent failed", e);
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "Phone Number Hint failed", e);
                });*/

        //Old
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent intent = Credentials.getClient(this.getActivity()).getHintPickerIntent(hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(), CREDENTIAL_PICKER_REQUEST, null, 0, 0, 0, new Bundle());
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREDENTIAL_PICKER_REQUEST && resultCode == RESULT_OK) {
            // Obtain the phone number from the result
            Credential credentials = data.getParcelableExtra(Credential.EXTRA_KEY);
            binding.tvMobileNumber.setText(credentials.getId().substring(3)); //get the selected phone number
        }
    }
}