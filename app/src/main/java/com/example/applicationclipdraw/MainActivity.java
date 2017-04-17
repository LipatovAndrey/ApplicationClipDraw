package com.example.applicationclipdraw;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.icu.util.ValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView1;
    View secondLayerlistView;
    ClipDrawable clipDrawable, clipDrawable2;
    ValueAnimator mAnimator;
    LayerDrawable layerDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondLayerlistView = findViewById(R.id.secondLayerlistView);
        imageView = (ImageView) findViewById(R.id.imageView);


        layerDrawable = (LayerDrawable) secondLayerlistView.getBackground();
        clipDrawable2 = (ClipDrawable) layerDrawable.getDrawable(2);
        // Создаём аниматор
        clipDrawable = (ClipDrawable) imageView.getDrawable();


        mAnimator = ValueAnimator.ofInt(0, 10000);

        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                clipDrawable.setLevel(value);
                clipDrawable2.setLevel(value);

            }
        });
        mAnimator.start();

    }

}
