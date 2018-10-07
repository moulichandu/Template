package com.yeeooh.jpmorgan.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Employee on 3/9/2018.
 */

public class CustomTextviewBold extends android.support.v7.widget.AppCompatTextView
{
    public CustomTextviewBold(Context context) {
        super(context);
        init();
    }

    public CustomTextviewBold(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextviewBold(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/arial_bold.ttf");
        setTypeface(tf);

    }
}
