package com.example.wastefoodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResetPassword extends AppCompatActivity {
    TextView text;
    EditText t1,t2;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        text=findViewById(R.id.t1);
        bt=findViewById(R.id.b1);
        t1=findViewById(R.id.e1);
        t2=findViewById(R.id.e2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }

            private void saveTask() {
                final String val = t1.getText().toString().trim();
                final String val1 = t2.getText().toString().trim();
                String passwordVal = "^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$";
                if (val.isEmpty()) {
                    t1.setError("Field cannot be empty");
                    return;
                } if (!val.matches(passwordVal)) {
                    t1.setError("Password is too weak");
                    return;
                }
                if (val1.isEmpty()) {
                    t1.setError("Field cannot be empty");
                    return;
                } if (!val1.matches(passwordVal)) {
                    t1.setError("Password is too weak");
                    return;
                }else if(!val.equals(val1)){
                    Intent i=new Intent(ResetPassword.this,LoginPage.class);
                    startActivity(i);
                    return;
                }
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResetPassword.this,LoginPage.class);
                startActivity(i);
            }

        });
    }
}