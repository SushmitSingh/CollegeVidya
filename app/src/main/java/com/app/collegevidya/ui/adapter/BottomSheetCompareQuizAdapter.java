package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.base.BaseRecyclerViewAdapter;
import com.app.collegevidya.base.BaseViewHolder;
import com.app.collegevidya.data.model.CompareQuizModel;
import com.app.collegevidya.data.viewmodel.BottomSheetCompareViewModel;
import com.app.collegevidya.databinding.EmptyVideoBinding;
import com.app.collegevidya.databinding.ItemBottomSheetCompareBinding;
import com.app.collegevidya.utils.AppConstants;

import java.util.List;

public class BottomSheetCompareQuizAdapter extends BaseRecyclerViewAdapter<CompareQuizModel> {

    private final Context mContext;

    public BottomSheetCompareQuizAdapter(List<CompareQuizModel> items, Context context) {
        super(items);
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return getItems() != null && !getItems().isEmpty() ? AppConstants.VIEW_TYPE_NORMAL : AppConstants.VIEW_TYPE_EMPTY;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case AppConstants.VIEW_TYPE_NORMAL:
                return new BottomSheetCompareQuizAdapter.CompareQuizModelsViewHolder(ItemBottomSheetCompareBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case AppConstants.VIEW_TYPE_EMPTY:
            default:
                return new BottomSheetCompareQuizAdapter.EmptyViewHolder(EmptyVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void addItems(List<CompareQuizModel> items) {
        this.clearItems();
        super.addItems(items);
    }

    public interface OptionClickListener extends BaseItemListener<CompareQuizModel> {

    }

    public class CompareQuizModelsViewHolder extends BaseViewHolder implements BottomSheetCompareViewModel.BottomSheetQuizItemClickListener {

        private final ItemBottomSheetCompareBinding itemBottomSheetCompareBinding;

        public CompareQuizModelsViewHolder(@NonNull ItemBottomSheetCompareBinding itemBottomSheetCompareBinding) {
            super(itemBottomSheetCompareBinding.getRoot());
            this.itemBottomSheetCompareBinding = itemBottomSheetCompareBinding;
        }

        @Override
        public void onBind(int position) {
            final CompareQuizModel compareQuizModel = getItems().get(position);
            this.itemBottomSheetCompareBinding.setViewModel(new BottomSheetCompareViewModel(compareQuizModel, this));
            this.itemBottomSheetCompareBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(View view, CompareQuizModel item) {
            if (item != null) {

            }
            Log.d("item", "onItemClick: " + item.getQuizOptions());

        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        private final EmptyVideoBinding emptyVideoBinding;

        public EmptyViewHolder(@NonNull EmptyVideoBinding emptyVideoBinding) {
            super(emptyVideoBinding.getRoot());
            this.emptyVideoBinding = emptyVideoBinding;
        }

        @Override
        public void onBind(int position) {
            this.emptyVideoBinding.executePendingBindings();
        }

    }

}