package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Movies extends AppCompatActivity {


    String[] mobileArray = {"sssdada","sdsaddsa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview,R.id.Itemname,mobileArray);
        ListView listview = (ListView) findViewById(R.id.aListView);
        listview.setAdapter(adapter);
    }



    public void addMovieScreen(View aMV){
        Intent intent = new Intent(this, AddMovie.class);
        startActivity(intent);
    }
}
