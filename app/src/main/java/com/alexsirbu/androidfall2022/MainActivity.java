package com.alexsirbu.androidfall2022;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alexsirbu.androidfall2022.activities.FirstActivity;
import com.alexsirbu.androidfall2022.navigation.NavigationActivity;
import com.alexsirbu.androidfall2022.storage.StorageActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewDisplayAccount;
    private Button buttonDisplayAboutAndroid;
    private Button buttonOpenActivity;
    private Button buttonOpenNavigationActivity;
    private Button buttonOpenStorageActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setupViews();
        displayAboutAndroidOnClick();
        openActivityOnClick();
        openNavActOnClick();
        openStorageActivity();
    }

    private void openStorageActivity() {
        buttonOpenStorageActivity.setOnClickListener(view -> {
            Intent storageActivity = new Intent(MainActivity.this, StorageActivity.class);
            startActivity(storageActivity);
        });
    }

    private void openNavActOnClick() {
        buttonOpenNavigationActivity.setOnClickListener(view -> {
            Intent navigationActivity = new Intent(MainActivity.this, NavigationActivity.class);
            startActivity(navigationActivity);
        });
    }

    private void setupViews() {
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        buttonDisplayAboutAndroid = findViewById(R.id.buttonAboutAndroid);
        buttonOpenActivity = findViewById(R.id.buttonOpenActivity);
        buttonOpenNavigationActivity = findViewById(R.id.buttonOpenNavigationActivity);
        buttonOpenStorageActivity = findViewById(R.id.buttonOpenStorageActivity);
    }

    private void displayAboutAndroidOnClick() {
        buttonDisplayAboutAndroid.setOnClickListener(view -> {
            Intent moveFromMainToAboutAndroidActivity = new Intent(MainActivity.this, AboutAndroid.class);
            startActivity(moveFromMainToAboutAndroidActivity);
        });
    }

    private void openActivityOnClick() {
        buttonOpenActivity.setOnClickListener(view -> {
            Intent openNewActivity = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(openNewActivity);
        });
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        
        boolean valid = true;
        if (!(email.length() > 0)) {
            editTextEmail.setError(getString(R.string.email_error));
            Log.e(TAG, "email empty");
            valid = false;
        }

        if (!(password.length() > 0)) {
            editTextPassword.setError(getString(R.string.password_error));
            Log.e(TAG, "password empty");
            valid = false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //editTextEmail.setError("Email is not valid");
            Toast.makeText(MainActivity.this, getString(R.string.email_not_valid), Toast.LENGTH_LONG)
                    .show();
            valid = false;
        }

        if (valid) {
            textViewDisplayAccount.setText(String.format("%s, %s", email, password));
            Intent displayMoviesActivity = new Intent(MainActivity.this, MoviesActivity.class);
            startActivity(displayMoviesActivity);
        }
    }
}