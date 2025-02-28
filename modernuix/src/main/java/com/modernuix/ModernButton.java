package com.modernuix;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class ModernButton extends androidx.appcompat.widget.AppCompatButton {
    private int gradientStart, gradientEnd;

    public ModernButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        // Parse custom attributes
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ModernButton);
        gradientStart = ta.getColor(R.styleable.ModernButton_buttonGradientStart, Color.BLUE);
        gradientEnd = ta.getColor(R.styleable.ModernButton_buttonGradientEnd, Color.CYAN);
        int iconRes = ta.getResourceId(R.styleable.ModernButton_iconSrc, 0);
        ta.recycle();

        // Setup gradient background
        GradientDrawable gradient = new GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            new int[]{gradientStart, gradientEnd}
        );
        gradient.setCornerRadius(32 * getResources().getDisplayMetrics().density);
        
        // Ripple effect
        RippleDrawable ripple = new RippleDrawable(
            ColorStateList.valueOf(Color.WHITE),
            gradient,
            null
        );

        setBackground(ripple);
        setElevation(4f);
        
        // Set icon if available
        if(iconRes != 0) {
            setCompoundDrawablesWithIntrinsicBounds(iconRes, 0, 0, 0);
            setCompoundDrawablePadding(16);
        }
    }
}
