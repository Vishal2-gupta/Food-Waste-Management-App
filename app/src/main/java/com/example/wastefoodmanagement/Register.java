package com.example.wastefoodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button btn;
    EditText et,et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn=findViewById(R.id.b1);
        et=findViewById(R.id.name);
        et1=findViewById(R.id.email);
        et2=findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();

            }

            private void saveTask() {
                final String n = et.getText().toString();
                final String Email = et1.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                final String val = et2.getText().toString().trim();
                String passwordVal = "^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$";
                if (n.isEmpty()) {
                    et.setError("Field cannot be empty");
                    return;
                }

                if (Email.isEmpty()) {
                    et1.setError("Email required");
                    return ;
                } if (!Email.matches(emailPattern)) {
                    et1.setError("Invalid email address");
                    return;
                }
                if (val.isEmpty()) {
                    et2.setError("Field cannot be empty");
                    return;
                } if (!val.matches(passwordVal)) {
                    et2.setError("Password is too weak");
                    return;
                } else {
                    Intent i=new Intent(Register.this,LoginPage.class);
                    startActivity(i);
                    return;
                }


            }
        });

    }
}