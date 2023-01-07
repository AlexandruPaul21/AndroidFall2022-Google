package com.alexsirbu.androidfall2022.storage;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alexsirbu.androidfall2022.R;

public class StorageActivity extends AppCompatActivity {

    private static final String TAG = "StorageActivity";

    protected static final String COLOR = "color";
    protected static final String SLIDES = "slides";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        useSharedPreferences();
    }

    private void useSharedPreferences() {
        //save
        ApplicationData.setStringValueInSharedPreferences(StorageActivity.this, COLOR, "blue");
        ApplicationData.setIntValueInSharedPreferences(StorageActivity.this, SLIDES, 7);

        //get values
        String valueColor = ApplicationData.getStringValueFromSharedPreferences(StorageActivity.this, COLOR);
        Toast.makeText(StorageActivity.this, valueColor, Toast.LENGTH_LONG).show();

        int valuesSlides = ApplicationData.getIntValueFromSharedPreferences(StorageActivity.this, SLIDES);
        Toast.makeText(StorageActivity.this, valuesSlides + "", Toast.LENGTH_LONG).show();

        //delete
        ApplicationData.deleteAllValuesFromSharedPreferences(StorageActivity.this);

    }
}