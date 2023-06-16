package com.example.cefimandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.cefimandroid.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(
                Context.CONNECTIVITY_SERVICE
        );

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        } else {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.network_not_found);
        }

    }

    /*private void showCustomToast(MainActivity main, String message) {
        Toast.makeText(
                main,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }*/

    public void handleBookmarks(View v) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        EditText text = findViewById(R.id.message);

        Log.d("messageTextFromMain", String.valueOf(text.getText()));

        intent.putExtra("messageText", String.valueOf(text.getText()));

        startActivity(intent);
    }
}