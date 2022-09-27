package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.collegevidya.data.viewmodel.SelectProductViewModel;
import com.app.collegevidya.databinding.ItemDashboardSliderBinding;

import java.util.ArrayList;

public class SelectProductAdapter extends RecyclerView.Adapter<SelectProductAdapter.MyAdapter> {

    ArrayList<SelectProductViewModel> data;
    Context mContext;
    private LayoutInflater inflater;

    public SelectProductAdapter(ArrayList<SelectProductViewModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SelectProductAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemDashboardSliderBinding itemDashboardSliderBinding = ItemDashboardSliderBinding.inflate(inflater, parent, false);
        return new SelectProductAdapter.MyAdapter(itemDashboardSliderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectProductAdapter.MyAdapter holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private ItemDashboardSliderBinding ItemDashboardSliderBinding;

        public MyAdapter(ItemDashboardSliderBinding ItemDashboardSliderBinding) {
            super(ItemDashboardSliderBinding.getRoot());
            this.ItemDashboardSliderBinding = ItemDashboardSliderBinding;
        }

        public void bind(SelectProductViewModel selectProductViewModel) {
            this.ItemDashboardSliderBinding.setViewModel(selectProductViewModel);
        }

        public ItemDashboardSliderBinding getItemDashboardSliderBinding() {
            return ItemDashboardSliderBinding;
        }
    }
}
