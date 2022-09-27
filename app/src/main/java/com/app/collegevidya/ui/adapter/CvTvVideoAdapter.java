package com.app.collegevidya.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.app.collegevidya.base.BaseItemListener;
import com.app.collegevidya.base.BaseRecyclerViewAdapter;
import com.app.collegevidya.base.BaseViewHolder;
import com.app.collegevidya.data.model.CvTvVideoModel;
import com.app.collegevidya.data.viewmodel.CvTvVideoViewModel;
import com.app.collegevidya.databinding.EmptyVideoBinding;
import com.app.collegevidya.databinding.ItemCvtvVideoBinding;
import com.app.collegevidya.ui.HomeActivity;
import com.app.collegevidya.ui.cvtv.CvTvVideoFraggmentDirections;
import com.app.collegevidya.utils.AppConstants;

import java.util.List;

public class CvTvVideoAdapter extends BaseRecyclerViewAdapter<CvTvVideoModel> {

    private FavoritesAdapterListener favoritesAdapterListener;
    private NavController navController;
    private final Context mContext;

    public CvTvVideoAdapter(List<CvTvVideoModel> items, Context context) {
        super(items);
        this.mContext = context;
    }

    public void setListener(FavoritesAdapterListener favoritesAdapterListener) {
        this.favoritesAdapterListener = favoritesAdapterListener;
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
                return new CvTvVideoAdapter.CvTvVideoModelsViewHolder(ItemCvtvVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case AppConstants.VIEW_TYPE_EMPTY:
            default:
                return new CvTvVideoAdapter.EmptyViewHolder(EmptyVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void addItems(List<CvTvVideoModel> items) {
        this.clearItems();
        super.addItems(items);
    }

    public interface FavoritesAdapterListener extends BaseItemListener<CvTvVideoModel> {

    }

    public class CvTvVideoModelsViewHolder extends BaseViewHolder implements CvTvVideoViewModel.CvTvVideoClickListener {

        private final ItemCvtvVideoBinding ItemCvtvVideoBinding;

        public CvTvVideoModelsViewHolder(@NonNull ItemCvtvVideoBinding ItemCvtvVideoBinding) {
            super(ItemCvtvVideoBinding.getRoot());
            this.ItemCvtvVideoBinding = ItemCvtvVideoBinding;
        }

        @Override
        public void onBind(int position) {
            final CvTvVideoModel CvTvVideoModel = getItems().get(position);
            this.ItemCvtvVideoBinding.setViewModel(new CvTvVideoViewModel(CvTvVideoModel, this));
            this.ItemCvtvVideoBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(View view, String item) {
            Log.d("item", "onItemClick: " + item);
            navController = Navigation.findNavController(view);
            CvTvVideoFraggmentDirections.ActionCvTvVideoFraggmentToExoPlayerFragment action = CvTvVideoFraggmentDirections.actionCvTvVideoFraggmentToExoPlayerFragment();
            action.setUrl(item);
            navController.navigate(action);
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