package com.example.cefimandroid.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cefimandroid.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cefimandroid.adapters.BookmarkAdapter;
import com.example.cefimandroid.databinding.ActivityBookmarkBinding;
import com.example.cefimandroid.models.City;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    private ActivityBookmarkBinding binding;

    private final ArrayList<City> mCities = new ArrayList<>();
    private AlertDialog.Builder builder;

    BookmarkAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        City city1 = new City("Montréal", "Légères pluies", "22°C", R.drawable.weather_rainy_grey);
        City city2 = new City("New York", "Ensoleillé", "22°C", R.drawable.weather_sunny_grey);
        City city3 = new City("Paris", "Nuageux", "24°C", R.drawable.weather_foggy_grey);
        City city4 = new City("Toulouse", "Pluies modérées", "20°C", R.drawable.weather_rainy_grey);
        City city5 = new City("Tours", "y fé bo", "5000°F", R.drawable.weather_sunny_white);

        mCities.add(city1);
        mCities.add(city2);
        mCities.add(city3);
        mCities.add(city4);
        mCities.add(city5);

        RecyclerView recyclerView = findViewById(R.id.bookmark_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookmarkAdapter(mCities);
        recyclerView.setAdapter(mAdapter);

        Log.d("BookmarkActivity", "recyclerView: " + recyclerView);
        Log.d("BookmarkActivity", "mAdapter: " + mAdapter);
    }

    public void handleOpenDialog(View v) {
        builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_add_bookmark, null);
        builder.setView(view);

        TextView acceptBtn = view.findViewById(R.id.accept_btn_bookmark);
        TextView cancelBtn = view.findViewById(R.id.cancel_btn_bookmark);


        AlertDialog dialog = builder.create();

        acceptBtn.setOnClickListener(view1 -> handleAddBookmark(view1, dialog));
        cancelBtn.setOnClickListener(view1 -> handleCloseDialog(view1, dialog));
        dialog.show();

        v.setTag(dialog);
    }

    public void handleCloseDialog(View v, Dialog d) {
        d.dismiss();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void handleAddBookmark(View v, Dialog d) {
        EditText editTextCity = d.findViewById(R.id.add_bookmark_input);
        String cityName = editTextCity.getText().toString();
        City city = new City(cityName, "Ensoleillé", "22°C", R.drawable.weather_sunny_grey);
        mCities.add(city);

        mAdapter.notifyDataSetChanged();
        d.dismiss();
    }
}