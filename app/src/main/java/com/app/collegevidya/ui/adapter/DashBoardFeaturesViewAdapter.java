package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.collegevidya.data.viewmodel.DashBoardFeaturesViewModel;
import com.app.collegevidya.databinding.ItemDashboardFeatureBinding;

import java.util.ArrayList;

public class DashBoardFeaturesViewAdapter extends RecyclerView.Adapter<DashBoardFeaturesViewAdapter.MyAdapter> {

    ArrayList<DashBoardFeaturesViewModel> data;
    Context mContext;
    private LayoutInflater inflater;

    public DashBoardFeaturesViewAdapter(ArrayList<DashBoardFeaturesViewModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DashBoardFeaturesViewAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemDashboardFeatureBinding itemDashboardFeatureBinding = ItemDashboardFeatureBinding.inflate(inflater, parent, false);
        return new DashBoardFeaturesViewAdapter.MyAdapter(itemDashboardFeatureBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DashBoardFeaturesViewAdapter.MyAdapter holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private final ItemDashboardFeatureBinding ItemDashboardFeatureBinding;

        public MyAdapter(ItemDashboardFeatureBinding itemDashboardFeatureBinding) {
            super(itemDashboardFeatureBinding.getRoot());
            this.ItemDashboardFeatureBinding = itemDashboardFeatureBinding;
        }

        public void bind(DashBoardFeaturesViewModel dashBoardFeaturesViewModel) {
            this.ItemDashboardFeatureBinding.setViewModel(dashBoardFeaturesViewModel);
        }

        public ItemDashboardFeatureBinding getItemDashboardFeatureBinding() {
            return ItemDashboardFeatureBinding;
        }
    }
}
