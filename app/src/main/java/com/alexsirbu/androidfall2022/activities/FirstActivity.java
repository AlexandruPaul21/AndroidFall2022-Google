package com.alexsirbu.androidfall2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.alexsirbu.androidfall2022.R;

public class FirstActivity extends AppCompatActivity {
    private final static String TAG = "FirstActivity";

    protected static final String MESSAGE = "message";
    protected static final String AGE = "age";
    protected static final String STATUS = "status";

    private Button buttonOpenSecondActivity;
    private Button buttonDial;
    private Button buttonOpenWebsite;
    private Button buttonSendMessage;
    private EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.e(TAG, "onCreate");

        setupButton();
        setupButtonDial();
        setupWebButton();

        setupButtonSendMessage();
    }

    private void setupButtonSendMessage() {
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        buttonSendMessage.setOnClickListener(view -> {
            String message = editTextMessage.getText().toString();
            if (message.length() > 0) {
                Intent sendMessage = new Intent(FirstActivity.this, SecondActivity.class);
                sendMessage.putExtra(MESSAGE, message);
                sendMessage.putExtra(AGE, 23);
                sendMessage.putExtra(STATUS, false);
                startActivity(sendMessage);
            }
        });
    }

    private void setupWebButton() {
        buttonOpenWebsite = findViewById(R.id.buttonOpenWebsite);
        buttonOpenWebsite.setOnClickListener(view -> {
            Intent openWebsite = new Intent(Intent.ACTION_VIEW);
            openWebsite.setData(Uri.parse("https://developer.android.com/"));
            startActivity(openWebsite);
        });
    }

    private void setupButtonDial() {
        buttonDial = findViewById(R.id.buttonDial);
        buttonDial.setOnClickListener(view -> {
            Intent dialActivity = new Intent(Intent.ACTION_DIAL);
            dialActivity.setData(Uri.parse("tel:0766238026"));
            startActivity(dialActivity);
        });
    }

    private void setupButton() {
        buttonOpenSecondActivity = findViewById(R.id.buttonOpenSecondActivity);
        buttonOpenSecondActivity.setOnClickListener(view -> {
            Intent openSecondActivity = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(openSecondActivity);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG, "onBackPressed");
    }
}