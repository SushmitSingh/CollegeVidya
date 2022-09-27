package com.app.collegevidya.ui.cvtv;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.collegevidya.data.model.CvTvOptionModel;
import com.app.collegevidya.data.model.CvTvVideoModel;
import com.app.collegevidya.databinding.FragmentCvTvVideoFraggmentBinding;
import com.app.collegevidya.ui.adapter.CvTvOptionAdapter;
import com.app.collegevidya.ui.adapter.CvTvVideoAdapter;

import java.util.ArrayList;
import java.util.List;

public class CvTvVideoFraggment extends Fragment {
    private final ArrayList<CvTvOptionModel> dataOptions = new ArrayList<>();
    private final List<CvTvVideoModel> dataVideos = new ArrayList<>();
    FragmentCvTvVideoFraggmentBinding binding;
    private Context mContext;


    public CvTvVideoFraggment() {
        // Required empty public constructor
    }

    public static CvTvVideoFraggment newInstance(String param1, String param2) {
        CvTvVideoFraggment fragment = new CvTvVideoFraggment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        createData();
    }

    private void createData() {
        CvTvVideoModel cvTvVideoModel = new CvTvVideoModel("https://www.youtube.com/watch?v=V58uibmqjHs", "Hi This Is Topic");
        dataVideos.add(cvTvVideoModel);

        cvTvVideoModel = new CvTvVideoModel("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "Hi This Is Topic");
        dataVideos.add(cvTvVideoModel);

        cvTvVideoModel = new CvTvVideoModel("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", "Hi This Is Topic");
        dataVideos.add(cvTvVideoModel);

        //Creating Options Data
        CvTvOptionModel cvTvOptionModel = new CvTvOptionModel("See All");
        dataOptions.add(cvTvOptionModel);

        cvTvOptionModel = new CvTvOptionModel("Horror");
        dataOptions.add(cvTvOptionModel);

        cvTvOptionModel = new CvTvOptionModel("Best");
        dataOptions.add(cvTvOptionModel);

        cvTvOptionModel = new CvTvOptionModel("New");
        dataOptions.add(cvTvOptionModel);

        cvTvOptionModel = new CvTvOptionModel("Creative");
        dataOptions.add(cvTvOptionModel);

        cvTvOptionModel = new CvTvOptionModel("Trending");
        dataOptions.add(cvTvOptionModel);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCvTvVideoFraggmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Set Up Options Recycler View
        binding.rvOptions.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        binding.rvOptions.setAdapter(new CvTvOptionAdapter(dataOptions, mContext));

        //Set Op Video Recycler View
        binding.rvVideos.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        binding.rvVideos.setAdapter(new CvTvVideoAdapter(dataVideos, mContext));

    }
}