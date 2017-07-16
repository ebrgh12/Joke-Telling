package com.manoj.displayjoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Manoj on 3/23/2017.
 */

public class DisplayJokeActivity extends AppCompatActivity {

    TextView display_joke;
    public static final String INTENT_JOKE = "intent:extra:joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);

        display_joke = (TextView) findViewById(R.id.display_joke);
        display_joke.setText(getIntent().getStringExtra(INTENT_JOKE));
    }
}
