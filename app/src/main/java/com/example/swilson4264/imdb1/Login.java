package com.example.swilson4264.imdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity
    implements View.OnClickListener {

    private Button signInBtn;
    private EditText emailTxt;
    private EditText passwordTxt;
    private Button signUpBtn;
    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = AppDatabase.getDatabase(getApplicationContext());

        signInBtn = (Button) findViewById(R.id.signInBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        emailTxt = (EditText) findViewById(R.id.emailTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);


        signUpBtn.setOnClickListener(this);
        signInBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){

                String sEmail = emailTxt.getText().toString();
                String sPassword = passwordTxt.getText().toString();
                User user = database.userDao().getUser(sEmail);

                if (user == null || !user.getEmail().equals(sEmail)) {
                    emailTxt.setError("Please enter a  valid username' ");
                }
                else if (sEmail.equals(user.getEmail()) && sPassword.equals(user.getPassword())) {

                    Intent intent = new Intent(Login.this, Movies.class);
                    startActivity(intent);

                }
                else if(user == null || !sPassword.equals(user.getEmail())){
                    //Toast.makeText(Login.this, "Please enter a valid password", Toast.LENGTH_LONG).show();
                    passwordTxt.setError("Please enter a valid password");
                }



            }
        });
    }




    @Override
            public void onClick(View view) {
//                if (view.getId() == R.id.signInBtn) {
//                    String sUserName = emailTxt.getText().toString();
//                    String sPassword = passwordTxt.getText().toString();
//                    User user = database.userDao().getUser(sUserName);
//
//                    if (sUserName == user.getEmail() && sPassword == user.getPassword()) {
//                        Intent intent = new Intent(this, HomeScrean.class);
//                        startActivity(intent);
//
//            }
////            if (!sUserName.contains("shelden")){
////                //Toast.makeText(this, "Please enter 'shelden' as username", Toast.LENGTH_LONG).show();
////                emailTxt.setError("Please enter the username 'shelden' ");
////            }
////            if (!sPassword.contains("password")){
////                //Toast.makeText(this, "Please enter 'password' as the password", Toast.LENGTH_LONG).show();
////                passwordTxt.setError("Please enter 'passowrd' as the password");
////            }
//
//
//        }
        if (view.getId() == R.id.signUpBtn) {
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
        }


    }

}
