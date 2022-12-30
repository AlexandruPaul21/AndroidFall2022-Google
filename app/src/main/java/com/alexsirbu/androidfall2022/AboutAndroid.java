package com.alexsirbu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class AboutAndroid extends AppCompatActivity {
    private static final String SANTA_URL = "https://santatracker.google.com/";

    private RatingBar ratingBarAndroid;
    private SwitchCompat switchBackup;
    private ProgressBar progressBarAboutAndroid;
    private WebView christmas;
    private Spinner citiesSpinner;

    private List<String> cities;

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

        christmas = findViewById(R.id.webViewChristmas);
        christmas.getSettings().setJavaScriptEnabled(true);
        christmas.loadUrl(SANTA_URL);

        setupSpinner();

    }
    //zero step -> spinner in XML - DONE

    //first step => define data source - DONE
    private void setCities() {
        cities = new ArrayList<>();
        cities.add("Pitesti");
        cities.add("Iasi");
        cities.add("Oradea");
        cities.add("Zalau");
        cities.add("Braila");
        cities.add("Bucuresti");
        cities.add("Craiova");
        cities.add("Galati");
        cities.add("Cluj");
        cities.add("Brasov");
        cities.add("Ploiesti");
        cities.add("Timisoara");
    }

    //second step => define adapter - DONE
    private ArrayAdapter<String> getDefaultAdapter() {
        return new ArrayAdapter<>(AboutAndroid.this, android.R.layout.simple_spinner_item, cities);
    }

    //third step => for spinner set the adapter
    private void setupSpinner() {
        citiesSpinner = findViewById(R.id.spinnerCitiesList);

        //populate the data source
        setCities();

        citiesSpinner.setAdapter(getDefaultAdapter());
    }

}