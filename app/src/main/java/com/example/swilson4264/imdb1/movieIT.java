package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class movieIT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_it);
    }

    public void addMovieScreen(View aMV){
        Uri web = Uri.parse("http://www.imdb.com/title/tt1396484");
        Intent intent = new Intent(Intent.ACTION_VIEW,web);

        startActivity(intent);
    }
}
