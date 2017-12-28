package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText emailTxt;
    private EditText passwordTxt;
    private Button signUpBtn;
    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = AppDatabase.getDatabase(getApplicationContext());

        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        emailTxt = (EditText) findViewById(R.id.emailTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        signUpBtn.setOnClickListener(this);
    }


public void onClick(View view) {
    if (view.getId() == R.id.signUpBtn) {
        String sEmail = emailTxt.getText().toString();
        String sPassword = passwordTxt.getText().toString();
        database.userDao().addUser(new User(1, emailTxt.getText().toString(),passwordTxt.getText().toString()));
            Intent intent = new Intent(this, Login.class);

            startActivity(intent);


    }
}
}
