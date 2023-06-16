package com.example.cefimandroid.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cefimandroid.R;
import com.example.cefimandroid.models.BookmarkViewHolder;
import com.example.cefimandroid.models.City;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {
    private final ArrayList<City> mCities;

    public BookmarkAdapter(ArrayList<City> cities) {
        mCities = cities;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookmark_item, parent, false);
        return new BookmarkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        City city = mCities.get(position);
        holder.cityDescTextView.setText(city.mDescription);
        holder.cityNameTextView.setText(city.mName);
        holder.cityTempTextView.setText(city.mTemperature);
        holder.weatherIcon.setImageResource(city.mWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }
}

