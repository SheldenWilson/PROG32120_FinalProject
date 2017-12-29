package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;


public class AddMovie extends AppCompatActivity implements View.OnClickListener{

    private Button saveMovieBtn;
    private EditText mNameTxt;
    private EditText mDescriptionTxt;
    private AppDatabase database;
    private Spinner aRatingSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        saveMovieBtn = (Button) findViewById(R.id.saveMovieBtn);
        saveMovieBtn.setOnClickListener(this);
        mNameTxt = (EditText) findViewById(R.id.mNameTxt);
        mDescriptionTxt = (EditText) findViewById(R.id.mDescriptionTxt);
        database = AppDatabase.getDatabase(getApplicationContext());

        aRatingSpinner =(Spinner)findViewById(R.id.aRatingSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ageRating_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        aRatingSpinner.setAdapter(adapter);


    }
    public void onClick(View view){
        List<Movie> movie = database.movieDao().getAllMovies();
        int x = movie.size();
        String mName = mNameTxt.getText().toString();
        String mDescription = mDescriptionTxt.getText().toString();
        int add = x + 1;
        database.movieDao().addMovie(new Movie(add,mNameTxt.getText().toString(),
                mDescriptionTxt.getText().toString()));
        Intent intent = new Intent(this,Movies.class);
        startActivity(intent);
    }
}
