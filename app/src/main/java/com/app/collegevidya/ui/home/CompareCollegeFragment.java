package com.app.collegevidya.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import com.app.collegevidya.R;
import com.app.collegevidya.data.model.CompareModel;
import com.app.collegevidya.data.model.CompareQuizModel;
import com.app.collegevidya.data.model.OptionsModel;
import com.app.collegevidya.data.viewmodel.OptionsViewModel;
import com.app.collegevidya.databinding.BottomSheetCompareBinding;
import com.app.collegevidya.databinding.FragmentCompareCollegeBinding;
import com.app.collegevidya.ui.HomeActivity;
import com.app.collegevidya.ui.adapter.BottomSheetCompareQuizAdapter;
import com.app.collegevidya.ui.adapter.CompareAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Objects;

public class CompareCollegeFragment extends Fragment {
    private final ArrayList<CompareModel> compareData = new ArrayList<>();
    private final ArrayList<CompareQuizModel> compareQuizData = new ArrayList<>();
    private final ArrayList<OptionsViewModel> optionData = new ArrayList<>();
    private final ArrayList<OptionsModel> optionData1 = new ArrayList<>();
    private FragmentCompareCollegeBinding binding;
    private Context mContext;
    private int bottomPageCount;

    public CompareCollegeFragment() {
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
        compareData();
        bottomSheetData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCompareCollegeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Open BottomSheet
        openBottomSheet(mContext);

        //open Side Nav
        binding.toolBar.imageView3.setOnClickListener(v ->
                ((HomeActivity) requireActivity()).openDrawer());

        //OverView RecyclerView
        binding.rvCompare.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        binding.rvCompare.setAdapter(new CompareAdapter(compareData, mContext));
    }

    private void compareData() {
        CompareModel CompareModel = new CompareModel("", "", "", "Nice", "");
        compareData.add(CompareModel);

        CompareModel CompareModel1 = new CompareModel("", "", "", "Very good", "");
        compareData.add(CompareModel1);

        CompareModel CompareModel2 = new CompareModel("", "", "", "Free Scholars", "");
        compareData.add(CompareModel2);

        CompareModel CompareModel3 = new CompareModel("", "", "", "", "");
        compareData.add(CompareModel3);

        CompareModel CompareModel4 = new CompareModel("", "", "", "", "");
        compareData.add(CompareModel4);

        CompareModel CompareModel5 = new CompareModel("", "", "", "", "");
        compareData.add(CompareModel5);
    }

    private void openBottomSheet(Context mContext) {
        BottomSheetCompareBinding bi;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext, R.style.BottomSheetDialog);
        bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        //inflating layout
        View view = View.inflate(getContext(), R.layout.bottom_sheet_compare, null);
        bottomSheetDialog.setContentView(view);
        //binding views to data binding.
        bi = DataBindingUtil.bind(view);

        /** Setup Adapter For Bottom Sheet
         SetUp AdapterFor BottomSheet ViewPage2 */
        assert bi != null;
        bi.vpQuiz.setAdapter(new BottomSheetCompareQuizAdapter(compareQuizData, mContext));
        /** New Quiz Load */
        bi.btnNext.setOnClickListener(v -> {
            if (bi.btnNext.getText().equals("Next")) {
                bi.vpQuiz.setCurrentItem(bi.vpQuiz.getCurrentItem() + 1);
            } else bottomSheetDialog.dismiss();
        });
        /**Back to Pre Quiz */
        bi.btnPre.setVisibility(View.INVISIBLE);
        bi.btnPre.setOnClickListener(v -> bi.vpQuiz.setCurrentItem(bi.vpQuiz.getCurrentItem() - 1));
        bi.vpQuiz.setNestedScrollingEnabled(false);
        bottomPageCount = Objects.requireNonNull(bi.vpQuiz.getAdapter()).getItemCount();
        bi.vpQuiz.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position >= 1) {
                    bi.btnPre.setVisibility(View.VISIBLE);
                } else bi.btnPre.setVisibility(View.INVISIBLE);
                if (bottomPageCount == position + 1) {
                    bi.btnNext.setText("Submit");
                }
            }
        });

        bottomSheetDialog.setOnDismissListener(dialog -> {
            Toast.makeText(mContext, "Matching Results ", Toast.LENGTH_SHORT).show();
        });
        bottomSheetDialog.show();
    }

    private void bottomSheetData() {

        OptionsViewModel optionsViewModel = new OptionsViewModel();
        OptionsViewModel optionsViewModel1 = new OptionsViewModel();
        optionsViewModel.options = "Yes";
        optionData.add(optionsViewModel);
        optionsViewModel1.options = "NO";
        optionData.add(optionsViewModel1);

        OptionsModel optionsModel = new OptionsModel("Yes");
        OptionsModel optionsModel1 = new OptionsModel("No");
        optionsViewModel.options = "Yes";
        optionData1.add(optionsModel);
        optionsViewModel1.options = "NO";
        optionData1.add(optionsModel1);

        CompareQuizModel CompareQuizModel = new CompareQuizModel("Are You Working Or Not", optionData1);
        compareQuizData.add(CompareQuizModel);

        CompareQuizModel = new CompareQuizModel("Your Highest Qualifications ?", optionData1);
        compareQuizData.add(CompareQuizModel);

        CompareQuizModel = new CompareQuizModel("Select Your Budget Options", optionData1);
        compareQuizData.add(CompareQuizModel);

        CompareQuizModel = new CompareQuizModel("How Many Study Hours", optionData1);
        compareQuizData.add(CompareQuizModel);
    }
}