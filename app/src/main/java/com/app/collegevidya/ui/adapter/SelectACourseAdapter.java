package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.collegevidya.data.viewmodel.SelectACourseViewModel;
import com.app.collegevidya.databinding.ItemCourseDashboardBinding;

import java.util.ArrayList;

public class SelectACourseAdapter extends RecyclerView.Adapter<SelectACourseAdapter.MyAdapter> {

    ArrayList<SelectACourseViewModel> data;
    Context mContext;
    private LayoutInflater inflater;

    public SelectACourseAdapter(ArrayList<SelectACourseViewModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemCourseDashboardBinding itemCourseDashboardBinding = ItemCourseDashboardBinding.inflate(inflater, parent, false);
        return new MyAdapter(itemCourseDashboardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private ItemCourseDashboardBinding itemCourseDashboardBinding;

        public MyAdapter(ItemCourseDashboardBinding itemCourseDashboardBinding) {
            super(itemCourseDashboardBinding.getRoot());
            this.itemCourseDashboardBinding = itemCourseDashboardBinding;
        }

        public void bind(SelectACourseViewModel selectACourseViewModel) {
            this.itemCourseDashboardBinding.setViewModel(selectACourseViewModel);
        }

        public ItemCourseDashboardBinding getItemCourseDashboardBinding() {
            return itemCourseDashboardBinding;
        }
    }
}
