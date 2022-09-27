package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.collegevidya.data.viewmodel.OverviewViewModel;
import com.app.collegevidya.databinding.ItemDashboardOvereviewBinding;

import java.util.ArrayList;

public class DashboardOverViewAdapter extends RecyclerView.Adapter<DashboardOverViewAdapter.MyAdapter> {

    ArrayList<OverviewViewModel> data;
    Context mContext;
    private LayoutInflater inflater;

    public DashboardOverViewAdapter(ArrayList<OverviewViewModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DashboardOverViewAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemDashboardOvereviewBinding itemDashboardOvereviewBinding = ItemDashboardOvereviewBinding.inflate(inflater, parent, false);
        return new DashboardOverViewAdapter.MyAdapter(itemDashboardOvereviewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardOverViewAdapter.MyAdapter holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private ItemDashboardOvereviewBinding itemDashboardOvereviewBinding;

        public MyAdapter(ItemDashboardOvereviewBinding itemDashboardOvereviewBinding) {
            super(itemDashboardOvereviewBinding.getRoot());
            this.itemDashboardOvereviewBinding = itemDashboardOvereviewBinding;
        }

        public void bind(OverviewViewModel overviewViewModel) {
            this.itemDashboardOvereviewBinding.setViewModel(overviewViewModel);
        }

        public ItemDashboardOvereviewBinding getItemDashboardOvereviewBinding() {
            return itemDashboardOvereviewBinding;
        }
    }
}
