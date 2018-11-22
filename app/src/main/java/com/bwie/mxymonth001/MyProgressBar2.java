package com.bwie.mxymonth001;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class MyProgressBar2 extends ProgressBar {
    public MyProgressBar2(Context context) {
        super(context);
    }

    public MyProgressBar2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyProgressBar2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
