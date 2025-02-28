package com.modernuix;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RadioGroup;

public class ModernRadioGroup extends RadioGroup {
    private View selector;
    private int selectorColor;
    private float cornerRadius;

    public ModernRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ModernRadioGroup);
        selectorColor = ta.getColor(R.styleable.ModernRadioGroup_selectorColor, Color.BLUE);
        cornerRadius = ta.getDimension(R.styleable.ModernRadioGroup_cornerRadius, 16);
        ta.recycle();

        // Create selector view
        selector = new View(getContext());
        selector.setBackgroundColor(selectorColor);
        selector.setAlpha(0.2f);
        addView(selector, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed) updateSelectorPosition();
    }

    private void updateSelectorPosition() {
        View checkedView = findViewById(getCheckedRadioButtonId());
        if(checkedView != null) {
            selector.animate()
                .x(checkedView.getX())
                .setDuration(200)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
            
            ValueAnimator anim = ValueAnimator.ofInt(selector.getWidth(), checkedView.getWidth());
            anim.addUpdateListener(animation -> {
                selector.getLayoutParams().width = (int) animation.getAnimatedValue();
                selector.requestLayout();
            });
            anim.setDuration(200).start();
        }
    }
}
