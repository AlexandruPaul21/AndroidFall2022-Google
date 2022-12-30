package com.alexsirbu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movieList;
    private RecyclerView moviesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        moviesRecyclerView = findViewById(R.id.recyclerViewMovies);
        setupRecyclerView();
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
    // step 2.2 => define the Adapter - DONE

    // step 3   => setup adapter for the RecyclerView
    // step 3.1 => setup Layout Manager
    private void setMoviesLayoutManager() {
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // step 3.2 => setup adapter
    private void setMoviesAdapter() {
        moviesRecyclerView.setAdapter(new MovieAdapter(movieList));
    }

    //step 3
    private void setupRecyclerView() {
        setMovies();
        setMoviesLayoutManager();
        setMoviesAdapter();
    }
}