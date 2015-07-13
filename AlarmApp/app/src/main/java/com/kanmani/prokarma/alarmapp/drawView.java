package com.kanmani.prokarma.alarmapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kanmani on 5/9/2015.
 */
public class drawView extends View {
    public drawView(Context context) {
        super(context);
    }

    public drawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public drawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(20,20,10,paint);
    }
}
