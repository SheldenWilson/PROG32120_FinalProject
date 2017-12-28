package com.example.swilson4264.imdb1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by swilson4264 on 12/5/2017.
 */
@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMovie(Movie movie);

    @Query("select * from movie")
    public List<Movie> getAllMovies();

    @Query("select * from movie where mName = :mName")
    public Movie getMovie(String mName);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movie movie);

    @Query("delete from Movie")
    void removeAllMovies();
}
