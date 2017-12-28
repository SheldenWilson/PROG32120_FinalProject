package com.example.swilson4264.imdb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MovieInfo extends AppCompatActivity {

    private Movie movie;
    private AppDatabase database;
    private TextView nameTxt;
    private TextView descriptionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        database = AppDatabase.getDatabase(getApplicationContext());
        nameTxt = (TextView) findViewById(R.id.nameTxt);
        descriptionTxt = (TextView) findViewById(R.id.descriptionTxt);
        List<Movie> movie = database.movieDao().getAllMovies();
        nameTxt.setText(movie.get(0).mName);
        descriptionTxt.setText(movie.get(0).mDescription);
    }


}
