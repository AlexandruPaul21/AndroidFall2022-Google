package com.alexsirbu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    // step 0 => Define RecyclerView in the .xml file & define the item template - DONE

    // step 1   => Create a data source
    // step 1.1 => Create dedicated class for Movie - DONE
    // step 1.2 => Populate the date source
    private void setMovies() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Home Alone", "Comedy", ""));
        movieList.add(new Movie("Harry Potter", "Fantasy", ""));
        movieList.add(new Movie("Kill Bill", "Action", ""));
        movieList.add(new Movie("Avatar", "Science-Fiction", ""));
        movieList.add(new Movie("Matrix", "Action", ""));
        movieList.add(new Movie("The Light House", "Science-Fiction", ""));
        movieList.add(new Movie("Anabelle", "Horror", ""));
        movieList.add(new Movie("Spiderman", "Action", ""));
        movieList.add(new Movie("Ironman", "Action", ""));
        movieList.add(new Movie("Lost", "Drama", ""));
    }

    // step 2   => get Custom Adapter
    // step 2.1 => define the ViewHolder - DONE
    // step 2.2 => define the Adapter

    // step 3   => setup adapter for the RecyclerView
    // step 3.1 => setup Layout Manager
    // step 3.2 => setup adapter
}