package com.alexsirbu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewDisplayAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);



    }

    //what could be improved here ????
    // check if either of them are void
    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        textViewDisplayAccount.setText(String.format("%s, %s", email, password));
    }
}