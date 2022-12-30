package com.alexsirbu.androidfall2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    //we create the pattern, general, no data used
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    //we put the data :)
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currMovie = movieList.get(position);
        holder.getTextViewTitle().setText(currMovie.getTitle());
        holder.getTextViewCategory().setText(currMovie.getCategory());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
