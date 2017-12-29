package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity {
    private Movie movie;
    private AppDatabase database;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        list.add("It");
        list.add("wilson");

        database = AppDatabase.getDatabase(getApplicationContext());
        List<Movie> movie = database.movieDao().getAllMovies();
//        list.add(movie.get(0).mName);
        int a = movie.size();
        if (a == 0) {

            Intent intent = new Intent(this, AddMovie.class);
            startActivity(intent);
        }

        if (a != 0 ){
            int counters = 0;
            for(int i=0; i<a; i++) {
                list.add(movie.get(counters).mName.toString());
                counters++;
            }
        }

       // list.add(movie.get(0).mName);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview,R.id.Itemname,list);
        ListView listview = (ListView) findViewById(R.id.aListView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                itpage(view);
            }
        });
    }



    public void addMovieScreen(View aMV){
        Intent intent = new Intent(this, AddMovie.class);
        startActivity(intent);
    }

    public void itpage(View view){
        Intent intents = new Intent(this, movieIT.class);
        startActivity(intents);
    }
}
