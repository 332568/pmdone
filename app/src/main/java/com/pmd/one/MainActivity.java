package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean checked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goAnimation(View view) {
        ImageView humanOneImageView = findViewById(R.id.OneImageView);
        ImageView humanTwoImageView = findViewById(R.id.TwoImageView);
        if (checked) {
            humanOneImageView.animate().alpha(0).rotation(humanOneImageView.getRotation() - 1080)
                    .scaleX(0).scaleY(0).setDuration(2000);
            humanTwoImageView.animate().alpha(1).rotation(humanTwoImageView.getRotation() -1080)
                    .scaleX(1).scaleY(1).setDuration(2000);
            checked = false;
        } else {
            humanOneImageView.animate().alpha(1).rotation(humanOneImageView.getRotation() - 1080)
                    .scaleX(1).scaleY(1).setDuration(2000);
            humanTwoImageView.animate().alpha(0).rotation(humanTwoImageView.getRotation() - 1080)
                    .scaleX(0).scaleY(0).setDuration(2000);
            checked = true;
        }
    }
}