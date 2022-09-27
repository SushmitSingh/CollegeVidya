package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.app.collegevidya.R;
import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.base.BaseRecyclerViewAdapter;
import com.app.collegevidya.base.BaseViewHolder;
import com.app.collegevidya.data.model.CompareModel;
import com.app.collegevidya.data.viewmodel.CompareViewModel;
import com.app.collegevidya.databinding.EmptyVideoBinding;
import com.app.collegevidya.databinding.ItemCompareUniversityBinding;
import com.app.collegevidya.utils.AppConstants;
import com.app.collegevidya.utils.ToolTipBalloon;
import com.skydoves.balloon.Balloon;

import java.util.List;

public class CompareAdapter extends BaseRecyclerViewAdapter<CompareModel> {

    private final Context mContext;
    //ToolTip Balloon
    private Balloon balloon;
    private CompareAdapter.ToolTipAdapterListener toolTipAdapterListener;

    public CompareAdapter(List<CompareModel> items, Context context) {
        super(items);
        this.mContext = context;
    }

    public void setListener(CompareAdapter.ToolTipAdapterListener toolTipAdapterListener) {
        this.toolTipAdapterListener = toolTipAdapterListener;
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
                return new CompareAdapter.CompareModelsViewHolder(ItemCompareUniversityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case AppConstants.VIEW_TYPE_EMPTY:
            default:
                return new CompareAdapter.EmptyViewHolder(EmptyVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void addItems(List<CompareModel> items) {
        this.clearItems();
        super.addItems(items);
    }

    public interface ToolTipAdapterListener extends BaseItemListener<CompareModel> {

    }

    public class CompareModelsViewHolder extends BaseViewHolder implements CompareViewModel.CompareClickListner {

        private final ItemCompareUniversityBinding itemCompareUniversityBinding;

        public CompareModelsViewHolder(@NonNull ItemCompareUniversityBinding ItemCompareUniversityBinding) {
            super(ItemCompareUniversityBinding.getRoot());
            this.itemCompareUniversityBinding = ItemCompareUniversityBinding;
        }

        @Override
        public void onBind(int position) {
            final CompareModel CompareModel = getItems().get(position);
            this.itemCompareUniversityBinding.setViewModel(new CompareViewModel(CompareModel, this));
            this.itemCompareUniversityBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(View view, String item) {
            Log.d("item", "onItemClick: " + item);

            //Init ToolTip Balloon Added In Compare Screen

            if (view.getId() == R.id.smallTooltip) {
                balloon = new ToolTipBalloon()
                        .balloonMaker(mContext, itemCompareUniversityBinding.getLifecycleOwner(), item + "small");
            } else {
                balloon = new ToolTipBalloon()
                        .balloonMaker(mContext, itemCompareUniversityBinding.getLifecycleOwner(), item);
            }

            //Show ToolTip Balloon
            if (!balloon.isShowing()) {
                balloon.showAlignTop(view);
            }

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