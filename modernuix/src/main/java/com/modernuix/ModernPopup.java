package com.modernuix;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.DialogFragment;

public class ModernPopup extends DialogFragment {
    private int layoutRes;
    private View.OnClickListener listener;

    public static ModernPopup newInstance(int layoutRes) {
        ModernPopup fragment = new ModernPopup();
        fragment.layoutRes = layoutRes;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes, container, false);
        setupBlurEffect();
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    private void setupBlurEffect() {
        // Untuk Android 12+ bisa menggunakan BackdropFilter
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            getView().setBackground(new android.graphics.drawable.RippleDrawable(
                android.content.res.ColorStateList.valueOf(0x20FFFFFF),
                null,
                new android.graphics.drawable.ShapeDrawable()
            ));
        }
    }

    public void setDismissListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, 
                (int) (getResources().getDisplayMetrics().heightPixels * 0.6));
        }
    }
}
