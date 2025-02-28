package com.modernuix;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;

public class ModernSwitch extends CompoundButton {
    private int thumbColor, trackActiveColor, trackInactiveColor;
    private boolean isAnimating = false;

    public ModernSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ModernSwitch);
        thumbColor = ta.getColor(R.styleable.ModernSwitch_thumbColor, Color.WHITE);
        trackActiveColor = ta.getColor(R.styleable.ModernSwitch_trackActiveColor, Color.BLUE);
        trackInactiveColor = ta.getColor(R.styleable.ModernSwitch_trackInactiveColor, Color.GRAY);
        ta.recycle();

        setBackground(createTrackDrawable());
    }

    private Drawable createTrackDrawable() {
        GradientDrawable track = new GradientDrawable();
        track.setShape(GradientDrawable.RECT);
        track.setCornerRadius(16);
        track.setColor(trackInactiveColor);
        return track;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!isAnimating && event.getAction() == MotionEvent.ACTION_UP) {
            toggle();
            animateSwitch();
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void animateSwitch() {
        isAnimating = true;
        
        // Thumb animation
        ObjectAnimator thumbAnim = ObjectAnimator.ofFloat(this, "thumbPosition", isChecked() ? 1 : 0);
        thumbAnim.setDuration(300);
        thumbAnim.start();

        // Track color animation
        ObjectAnimator colorAnim = ObjectAnimator.ofObject(
            getBackground(),
            "color",
            new ArgbEvaluator(),
            isChecked() ? trackInactiveColor : trackActiveColor,
            isChecked() ? trackActiveColor : trackInactiveColor
        );
        colorAnim.start();
    }
}
