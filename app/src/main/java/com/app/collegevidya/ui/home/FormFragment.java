package com.app.collegevidya.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.collegevidya.R;
import com.app.collegevidya.databinding.FragmentFormBinding;
import com.app.collegevidya.ui.HomeActivity;

public class FormFragment extends Fragment {
    FragmentFormBinding binding;

    public FormFragment() {
        // Required empty public constructor
    }

    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment'
        binding = FragmentFormBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolBar.imageView3.setOnClickListener(v ->
                ((HomeActivity) requireActivity()).openDrawer());

        binding.btnFindBestUni.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_formFragment_to_compareCollegeFragment);
        });
    }

}