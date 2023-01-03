package com.alexsirbu.androidfall2022.networking;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexsirbu.androidfall2022.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final ImageView userImage;
    private final TextView textUsername;
    private final TextView textId;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        userImage = itemView.findViewById(R.id.imageViewUser);
        textUsername = itemView.findViewById(R.id.textViewUsername);
        textId = itemView.findViewById(R.id.textViewId);
    }

    public ImageView getUserImage() {
        return userImage;
    }

    public TextView getTextUsername() {
        return textUsername;
    }

    public TextView getTextId() {
        return textId;
    }
}
