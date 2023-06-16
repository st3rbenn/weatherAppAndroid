package com.example.cefimandroid.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cefimandroid.R;

public class BookmarkViewHolder extends RecyclerView.ViewHolder {
    public TextView cityNameTextView;

    public TextView cityDescTextView;

    public ImageView weatherIcon;

    public TextView cityTempTextView;

    public BookmarkViewHolder(@NonNull View itemView) {
        super(itemView);
        cityNameTextView = itemView.findViewById(R.id.city_name);
        cityDescTextView = itemView.findViewById(R.id.city_desc);
        weatherIcon = itemView.findViewById(R.id.weather_icon);
        cityTempTextView = itemView.findViewById(R.id.city_temp);
    }
}
