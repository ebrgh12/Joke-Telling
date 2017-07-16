package com.joketellingapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.manoj.myapplication.backend.myApi.MyApi;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.manoj.displayjoke.DisplayJokeActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button sendJoke;

    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       MobileAds.initialize(getApplicationContext(), "ca-app-pub-8252375834374180~3607218153");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sendJoke = (Button) findViewById(R.id.populate_joke);
        sendJoke.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.populate_joke:

                new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Joke Telling App"));

                break;
        }
    }

    private class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>,Void,String>{

        private MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://6-dot-joketellingapp-ecb86.appspot.com/_ah/api/")
                        .setServicePath("myApi/v1/sayHi/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver
                myApiService = builder.build();

            }
            context = params[0].first;
            String name = params[0].second;

            try {
                return myApiService.sayHi(name).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("server response",result);

            Intent viewJokeIntent = new Intent(MainActivity.this, DisplayJokeActivity.class);
            viewJokeIntent.putExtra(DisplayJokeActivity.INTENT_JOKE, result);
            startActivity(viewJokeIntent);

        }
    }
}
