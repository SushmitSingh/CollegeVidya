package com.app.collegevidya.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.app.collegevidya.R;
import com.app.collegevidya.data.model.OnBoardingScreenModel;
import com.app.collegevidya.databinding.ActivitySplashBinding;
import com.app.collegevidya.ui.adapter.OnBoardingScreenAdapter;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    /**
     * This Adapter( OnBoardingScreenAdapter) For On-Boarding-Screen
     * 3 screens In OnBoarding
     */
    private OnBoardingScreenAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.background));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        /** If User Is First Time */
        if (restorePreData()) {
            homePage();
        }
        //Data

        /**
         * Adding Three Screen's Data in A List For Adapter
         * */
        final List<OnBoardingScreenModel> mList = new ArrayList<>();
        mList.add(new OnBoardingScreenModel(getString(R.string.selection_process), getString(R.string.explore_compare), R.drawable.splash_one));
        mList.add(new OnBoardingScreenModel(getString(R.string.our_guidance), getString(R.string.make_the_best), R.drawable.splash_two));
        mList.add(new OnBoardingScreenModel(getString(R.string.we_got_you), getString(R.string.from_pre_ad), R.drawable.splash_three));

        //Setup viewPager
        introViewPagerAdapter = new OnBoardingScreenAdapter(this, mList);
        binding.viewPager.setAdapter(introViewPagerAdapter);

        binding.viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            private static final float MIN_SCALE = 0.75f;
            private static final float MIN_ALPHA = 0.6f;

            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.setAlpha(0f);

                } else if (position <= 1) { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.setAlpha(0f);
                }
            }
        });
        binding.dotsIndicator.setViewPager(binding.viewPager);
        binding.back.setVisibility(View.INVISIBLE);
        //Button Next
        binding.next.setOnClickListener(view -> {
            if (binding.next.getText().equals("Finish")) {
                homePage();
            } else
                binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() + 1, true);
        });
        binding.back.setOnClickListener(v -> {
            binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() - 1, true);
        });

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (binding.viewPager.getCurrentItem() == mList.size()-1)
                    binding.next.setText("Finish");

                if (binding.viewPager.getCurrentItem() == 0) {
                    binding.back.setVisibility(View.INVISIBLE);
                } else binding.back.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Button Get Started
        binding.skip.setOnClickListener(view -> homePage());
    }

    //Start Auth Activity
    private void homePage() {
        Intent authActivity = new Intent(getApplicationContext(), AuthActivity.class);
        startActivity(authActivity);
        savePrefsData();
        finish();
    }

    private boolean restorePreData() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

}