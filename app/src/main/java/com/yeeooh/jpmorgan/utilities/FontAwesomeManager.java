package com.yeeooh.jpmorgan.utilities;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Purushotham on 12/1/2017.
 */

public class FontAwesomeManager {

    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

}
