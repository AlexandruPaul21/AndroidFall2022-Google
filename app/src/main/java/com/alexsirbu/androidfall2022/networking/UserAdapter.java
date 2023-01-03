package com.alexsirbu.androidfall2022.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexsirbu.androidfall2022.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private final List<User> usersList;

    public UserAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currUser = usersList.get(position);
        holder.getTextUsername().setText(currUser.getUsername());

        String id = String.valueOf(currUser.getId());
        holder.getTextId().setText(id);
        Picasso.get().load(currUser.getAvatarUrl())
                .placeholder(R.drawable.github_icon)
                .into(holder.getUserImage());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
