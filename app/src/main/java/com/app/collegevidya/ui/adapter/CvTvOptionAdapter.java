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
import com.app.collegevidya.data.model.CvTvOptionModel;
import com.app.collegevidya.data.viewmodel.CvTvOptionsViewModel;
import com.app.collegevidya.databinding.EmptyVideoBinding;
import com.app.collegevidya.databinding.ItemCvtvOptionsBinding;
import com.app.collegevidya.utils.AppConstants;
import java.util.List;

public class CvTvOptionAdapter extends BaseRecyclerViewAdapter<CvTvOptionModel> {

    private final Context mContext;

    public CvTvOptionAdapter(List<CvTvOptionModel> items, Context context) {
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
                return new CvTvOptionAdapter.CvTvOptionModelsViewHolder(ItemCvtvOptionsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case AppConstants.VIEW_TYPE_EMPTY:
            default:
                return new CvTvOptionAdapter.EmptyViewHolder(EmptyVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void addItems(List<CvTvOptionModel> items) {
        this.clearItems();
        super.addItems(items);
    }

    public interface OptionClickListener extends BaseItemListener<CvTvOptionModel> {

    }

    public class CvTvOptionModelsViewHolder extends BaseViewHolder implements CvTvOptionsViewModel.CvTvOptionClickListener {

        private final ItemCvtvOptionsBinding itemCvtvOptionsBinding;

        public CvTvOptionModelsViewHolder(@NonNull ItemCvtvOptionsBinding itemCvtvOptionsBinding) {
            super(itemCvtvOptionsBinding.getRoot());
            this.itemCvtvOptionsBinding = itemCvtvOptionsBinding;
        }

        @Override
        public void onBind(int position) {
            final CvTvOptionModel CvTvOptionModel = getItems().get(position);
            this.itemCvtvOptionsBinding.setViewModel(new CvTvOptionsViewModel(CvTvOptionModel, this));
            this.itemCvtvOptionsBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(View view, CvTvOptionModel item) {
            if (item != null){

            }
            Log.d("item", "onItemClick: " + item.getOption());

        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        private final EmptyVideoBinding EmptyVideoBinding;

        public EmptyViewHolder(@NonNull EmptyVideoBinding EmptyVideoBinding) {
            super(EmptyVideoBinding.getRoot());
            this.EmptyVideoBinding = EmptyVideoBinding;
        }

        @Override
        public void onBind(int position) {
            this.EmptyVideoBinding.executePendingBindings();
        }

    }

}