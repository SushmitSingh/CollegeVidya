package com.app.collegevidya.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.collegevidya.R;
import com.app.collegevidya.data.viewmodel.DashBoardFeaturesViewModel;
import com.app.collegevidya.data.viewmodel.OverviewViewModel;
import com.app.collegevidya.data.viewmodel.SelectACourseViewModel;
import com.app.collegevidya.data.viewmodel.SelectProductViewModel;
import com.app.collegevidya.databinding.FragmentHomeBinding;
import com.app.collegevidya.ui.HomeActivity;
import com.app.collegevidya.ui.adapter.DashBoardFeaturesViewAdapter;
import com.app.collegevidya.ui.adapter.DashboardOverViewAdapter;
import com.app.collegevidya.ui.adapter.SelectACourseAdapter;
import com.app.collegevidya.ui.adapter.SelectProductAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<SelectACourseViewModel> courseData = new ArrayList<>();
    ArrayList<SelectProductViewModel> productData = new ArrayList<>();
    ArrayList<OverviewViewModel> overviewData = new ArrayList<>();
    ArrayList<DashBoardFeaturesViewModel> featureData = new ArrayList<>();
    private Context mContext;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;

        //Creating Sample Data
        createDataForSelectProduct();
        createDataForCourse();
        createDataForOverview();
        createFeatureData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Open Navigation
        binding.include.imageView3.setOnClickListener(v ->
                ((HomeActivity) requireActivity()).openDrawer());

        //Controlling Dashboard Tab
        binding.tvPgCourse.setActivated(true);
        binding.tvPgCourse.setOnClickListener(v -> pgClick());
        binding.tvUgCourse.setOnClickListener(v -> ugClick());
        binding.tvDipCer.setOnClickListener(v -> dipAndCir());

        //Course RecyclerView
        binding.rvCourse.setLayoutManager(new GridLayoutManager(mContext, 3));
        binding.rvCourse.setAdapter(new SelectACourseAdapter(courseData, mContext));

        //Select A Product RecyclerView
        binding.rvSelectProduct.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        binding.rvSelectProduct.setAdapter(new SelectProductAdapter(productData, mContext));

        //OverView RecyclerView
        binding.rvOverview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        binding.rvOverview.setAdapter(new DashboardOverViewAdapter(overviewData, mContext));

        //OverView RecyclerView
        binding.rvFeature.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        binding.rvFeature.setAdapter(new DashBoardFeaturesViewAdapter(featureData, mContext));

    }

    private void createFeatureData() {
        DashBoardFeaturesViewModel dashBoardFeaturesViewModel = new DashBoardFeaturesViewModel();
        dashBoardFeaturesViewModel.feColor = "#B1F6FF";
        dashBoardFeaturesViewModel.feTextColor = "#248E9C";
        dashBoardFeaturesViewModel.feText = "Unbiased\nGuidance";
        featureData.add(dashBoardFeaturesViewModel);

        DashBoardFeaturesViewModel dashBoardFeaturesViewModel1 = new DashBoardFeaturesViewModel();
        dashBoardFeaturesViewModel1.feColor = "#C4FFC6";
        dashBoardFeaturesViewModel1.feTextColor = "#228227";
        dashBoardFeaturesViewModel1.feText = "Affordable\nPrice";
        featureData.add(dashBoardFeaturesViewModel1);

        DashBoardFeaturesViewModel dashBoardFeaturesViewModel2 = new DashBoardFeaturesViewModel();
        dashBoardFeaturesViewModel2.feColor = "#C8E6FF";
        dashBoardFeaturesViewModel2.feTextColor = "#0074D7";
        dashBoardFeaturesViewModel2.feText = "Most\nReliable";
        featureData.add(dashBoardFeaturesViewModel2);

    }

    private void createDataForOverview() {
        OverviewViewModel overviewViewModel = new OverviewViewModel();
        overviewViewModel.oDesc = "Students trust College\nVidya for providing\nUnbiased Counselling.";
        overviewViewModel.oColor = "#FFBB0C";
        overviewData.add(overviewViewModel);

        OverviewViewModel overviewViewModel1 = new OverviewViewModel();
        overviewViewModel1.oDesc = "Students trust College\nVidya for providing\nUnbiased Counselling.";
        overviewViewModel1.oColor = "#16D3ED";
        overviewData.add(overviewViewModel1);

    }

    private void createDataForSelectProduct() {
        SelectProductViewModel selectProductViewModel = new SelectProductViewModel();
        selectProductViewModel.descText = "Got any Question on\\nOnline &amp; Distance\\nEducation?\\nGive us a Call ";
        productData.add(selectProductViewModel);
        productData.add(selectProductViewModel);
    }

    private void createDataForCourse() {
        SelectACourseViewModel selectACourseViewModel = new SelectACourseViewModel();
        selectACourseViewModel.courseName = "MBA";
        selectACourseViewModel.courseCount = "Compare 25 College";
        courseData.add(selectACourseViewModel);

        SelectACourseViewModel selectACourseViewModel1 = new SelectACourseViewModel();
        selectACourseViewModel1.courseName = "CSE";
        selectACourseViewModel1.courseCount = "Compare 35 College";
        courseData.add(selectACourseViewModel1);

        SelectACourseViewModel selectACourseViewModel2 = new SelectACourseViewModel();
        selectACourseViewModel2.courseName = "BBA";
        selectACourseViewModel2.courseCount = "Compare 15 College";
        courseData.add(selectACourseViewModel2);

        SelectACourseViewModel selectACourseViewModel3 = new SelectACourseViewModel();
        selectACourseViewModel3.courseName = "BCA";
        selectACourseViewModel3.courseCount = "Compare 25 College";
        courseData.add(selectACourseViewModel3);

        SelectACourseViewModel selectACourseViewModel4 = new SelectACourseViewModel();
        selectACourseViewModel4.courseName = "CS";
        selectACourseViewModel4.courseCount = "Compare 25 College";
        courseData.add(selectACourseViewModel4);

        SelectACourseViewModel selectACourseViewModel5 = new SelectACourseViewModel();
        selectACourseViewModel5.courseName = "MBA";
        selectACourseViewModel5.courseCount = "Compare 45 College";
        courseData.add(selectACourseViewModel5);
    }

    private void dipAndCir() {
        binding.tvDipCer.setActivated(true);
        binding.tvUgCourse.setActivated(false);
        binding.tvPgCourse.setActivated(false);
        //TODO Open And Refresh Tha List Of Course
    }

    private void ugClick() {
        binding.tvUgCourse.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.bounce));
        binding.tvDipCer.setActivated(false);
        binding.tvUgCourse.setActivated(true);
        binding.tvPgCourse.setActivated(false);
        //TODO Open And Refresh Tha List Of Course
    }

    private void pgClick() {
        binding.tvDipCer.setActivated(false);
        binding.tvUgCourse.setActivated(false);
        binding.tvPgCourse.setActivated(true);
        //TODO Open And Refresh Tha List Of Course
    }

}
