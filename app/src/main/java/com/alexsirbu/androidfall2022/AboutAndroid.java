package com.alexsirbu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Switch;

public class AboutAndroid extends AppCompatActivity {

    private RatingBar ratingBarAndroid;
    private SwitchCompat switchBackup;
    private ProgressBar progressBarAboutAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_android);

        ratingBarAndroid = findViewById(R.id.ratingBarAndroid);
        ratingBarAndroid.getRating();

        switchBackup = findViewById(R.id.switchEnableBackup);
        switchBackup.isChecked();

        progressBarAboutAndroid = findViewById(R.id.progressBarAboutAndroid);
        progressBarAboutAndroid.setVisibility(View.INVISIBLE);
    }
}