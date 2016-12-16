package com.example.administrator.clickanim;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;


/**
 * Created by Administrator on 2016/9/12.
 * 点击效果动画弹窗
 */
public class ClickAnimsView extends PopupWindow implements Animation.AnimationListener {

    public ClickAnimsView (Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.water_layout, null),
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, false);
    }

    public void showAnim (View view, int x, int y) {
        showAtLocation(view, Gravity.NO_GRAVITY, x, y);
        //显示动画效果
        final ImageView imageView = (ImageView) getContentView().findViewById(R.id.water_layout_imageView);
        Animation animation = AnimationUtils.loadAnimation(getContentView().getContext(), R.anim.water_anim);
        animation.setAnimationListener(this);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        imageView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart (Animation animation) {

    }

    @Override
    public void onAnimationEnd (Animation animation) {
        //动画完成后自动关闭弹窗
        dismiss();
    }

    @Override
    public void onAnimationRepeat (Animation animation) {

    }
}
