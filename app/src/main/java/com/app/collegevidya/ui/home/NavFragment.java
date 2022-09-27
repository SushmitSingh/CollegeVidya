package com.app.collegevidya.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.app.collegevidya.R;
import com.app.collegevidya.databinding.FragmentNavBinding;
import com.app.collegevidya.ui.HomeActivity;

public class NavFragment extends Fragment {
    public NavController navController;
    private Context mContext;

    public NavFragment() {
        // Required empty public constructor
    }

    FragmentNavBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNavBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_homeFragment);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ivClose.setOnClickListener(v -> ((HomeActivity) requireActivity()).closeDrawer());
        binding.tvPgCourse.setOnClickListener(v -> {
                    ((HomeActivity) requireActivity()).closeDrawer();
                    navController.navigate(R.id.formFragment);
                }
        );

        binding.tvCvTv.setOnClickListener(v -> {
            ((HomeActivity) requireActivity()).closeDrawer();
            navController.navigate(R.id.cvTvVideoFraggment);
        });
    }
}