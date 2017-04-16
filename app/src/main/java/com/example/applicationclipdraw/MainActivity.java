package com.example.applicationclipdraw;

import android.animation.ValueAnimator;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.icu.util.ValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ClipDrawable clipDrawable;
    ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        // Создаём аниматор
        clipDrawable = (ClipDrawable) imageView.getDrawable();
        mAnimator = ValueAnimator.ofInt(0, 10000);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                clipDrawable.setLevel(value);
            }
        });
        mAnimator.start();

    }
}
