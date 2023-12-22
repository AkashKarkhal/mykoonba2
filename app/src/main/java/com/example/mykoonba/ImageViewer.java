package com.example.mykoonba;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageViewer extends AppCompatActivity {
    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        Intent i = getIntent();
        int img = i.getIntExtra("img", 1);

        imageView = findViewById(R.id.imageviewer_image);
        imageView.setImageResource(img);

        imageView.setScaleType(ImageView.ScaleType.MATRIX);

        // Initialize the ScaleGestureDetector
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass touch events to ScaleGestureDetector
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // Update the scale factor and apply it to the ImageView matrix
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f)); // Restrict the scale factor

            // Apply the scale factor to the ImageView
            imageView.setScaleX(scaleFactor);
            imageView.setScaleY(scaleFactor);

            return true;
        }
    }
}