package com.app.collegevidya.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;

import androidx.lifecycle.LifecycleOwner;

import com.app.collegevidya.R;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

public class ToolTipBalloon {
    public Balloon balloonMaker(Context mContext, LifecycleOwner lifecycleOwner,String text){
        Balloon balloon = new Balloon.Builder(mContext).setWidthRatio(1.0f)
                .setHeight(BalloonSizeSpec.WRAP)
                .setWidth(BalloonSizeSpec.WRAP)
                .setText(text)
                .setTextColorResource(R.color.white_text)
                .setTextSize(12f)
                .setMarginLeft(15)
                .setMarginRight(15)
                .setTextTypeface(Typeface.BOLD)
                .setTextGravity(Gravity.CENTER)
                .setWidthRatio(0.50f)
                .setIconSize(20)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowSize(9)
                .setArrowPosition(0.5f)
                .setPadding(6)
                .setCornerRadius(8f)
                .setBackgroundColorResource(R.color.Black_transparent_80)
                .setBalloonAnimation(BalloonAnimation.FADE)
                .setLifecycleOwner(lifecycleOwner)
                .build();
        return balloon;
    }
}
