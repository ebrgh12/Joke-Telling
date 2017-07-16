package com.joketellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Manoj on 3/16/2017.
 */

public class DisplayJoke extends AppCompatActivity {

    TextView display_joke;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);
        Intent intent = getIntent();

        display_joke = (TextView) findViewById(R.id.display_joke);
        display_joke.setText(intent.getStringExtra("data_value"));

    }
}
