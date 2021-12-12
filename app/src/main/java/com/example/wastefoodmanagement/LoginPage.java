package com.example.wastefoodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    Button btn,bt;
    TextView t;
    private EditText editText, editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        t=findViewById(R.id.reset);
        editText=findViewById(R.id.e1);
        editText1=findViewById(R.id.e2);
        btn=findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }

            private void saveTask() {
                final String Email = editText.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                final String val = editText1.getText().toString().trim();
                String passwordVal = "^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$";
                if (Email.isEmpty()) {
                    editText.setError("Email required");
                    return ;
                } if (!Email.matches(emailPattern)) {
                    editText.setError("Invalid email address");
                    return;
                }
                if (val.isEmpty()) {
                    editText1.setError("Field cannot be empty");
                    return;
                } if (!val.matches(passwordVal)) {
                    editText1.setError("Password is too weak");
                    return;
                } else {
                    Intent i=new Intent(LoginPage.this,NavigationDrawer.class);
                    startActivity(i);
                    return;
                }


            }
        });
        btn=findViewById(R.id.b2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginPage.this,Register.class);
                startActivity(i);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginPage.this,ResetPassword.class);
                startActivity(i);
            }
        });
    }
}