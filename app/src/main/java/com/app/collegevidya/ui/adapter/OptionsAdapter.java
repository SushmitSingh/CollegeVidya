package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.collegevidya.data.viewmodel.OptionsViewModel;
import com.app.collegevidya.databinding.ItemOptionsBinding;

import java.util.ArrayList;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.MyAdapter> {

    ArrayList<OptionsViewModel> data;
    Context mContext;
    private LayoutInflater inflater;

    public OptionsAdapter(ArrayList<OptionsViewModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OptionsAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemOptionsBinding itemOptionsBinding = ItemOptionsBinding.inflate(inflater, parent, false);
        return new OptionsAdapter.MyAdapter(itemOptionsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionsAdapter.MyAdapter holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        private final ItemOptionsBinding itemOptionsBinding;

        public MyAdapter(ItemOptionsBinding itemOptionsBinding) {
            super(itemOptionsBinding.getRoot());
            this.itemOptionsBinding = itemOptionsBinding;
        }

        public void bind(OptionsViewModel optionsViewModel) {
            this.itemOptionsBinding.setViewModel(optionsViewModel);
        }

        public ItemOptionsBinding getItemOptionsBinding() {
            return itemOptionsBinding;
        }
    }
}
