package com.alexsirbu.androidfall2022.storage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alexsirbu.androidfall2022.R;

import java.util.List;

public class StorageActivity extends AppCompatActivity {

    private static final String TAG = "StorageActivity";

    protected static final String COLOR = "color";
    protected static final String SLIDES = "slides";

    private WordViewModel wordViewModel;

    private Button buttonInsertWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        useSharedPreferences();

        buttonInsertWord = findViewById(R.id.buttonInsertWord);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        wordViewModel.getWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                Log.e(TAG, words.toString());
            }
        });

        insertNewWords();
    }

    private void insertNewWords() {
        buttonInsertWord.setOnClickListener(view -> {
            wordViewModel.insert(new Word("android " + System.currentTimeMillis()));
        });
    }

    private void useSharedPreferences() {
        //save
        ApplicationData.setStringValueInSharedPreferences(StorageActivity.this, COLOR, "blue");
        ApplicationData.setIntValueInSharedPreferences(StorageActivity.this, SLIDES, 7);

        //get values
        String valueColor = ApplicationData.getStringValueFromSharedPreferences(StorageActivity.this, COLOR);
        //Toast.makeText(StorageActivity.this, valueColor, Toast.LENGTH_LONG).show();

        int valuesSlides = ApplicationData.getIntValueFromSharedPreferences(StorageActivity.this, SLIDES);
        //Toast.makeText(StorageActivity.this, valuesSlides + "", Toast.LENGTH_LONG).show();

        //delete
        ApplicationData.deleteAllValuesFromSharedPreferences(StorageActivity.this);
        Log.wtf(TAG, "It is gone :'(");

    }
}