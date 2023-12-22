package com.example.mykoonba;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircularImageView extends androidx.appcompat.widget.AppCompatImageView {

    public CircularImageView(Context context) {
        super(context);
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float radius = getWidth() / 2f;
        Path path = new Path();
        path.addCircle(radius, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}