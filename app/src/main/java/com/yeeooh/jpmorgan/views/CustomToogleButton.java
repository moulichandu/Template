package com.yeeooh.jpmorgan.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * Created by Purushotham on 11/29/2017.
 */

public class CustomToogleButton extends ToggleButton
{
    public CustomToogleButton(Context context) {
        super(context);
        init();
    }

    public CustomToogleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomToogleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/arial.ttf");
        setTypeface(tf);

    }
}
