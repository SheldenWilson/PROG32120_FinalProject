package com.example.swilson4264.imdb1;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
/**
 * Created by swilson4264 on 11/28/2017.
 */
@Entity
public class User {

    @PrimaryKey
    public final int id;
    public String email;
    public String password;


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;

    }

}