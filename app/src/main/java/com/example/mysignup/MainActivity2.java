package com.example.mysignup;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.font.TextAttribute;


public class MainActivity2 extends AppCompatActivity {
    private TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        name = findViewById(R.id.text_username);
        email = findViewById(R.id.text_email);

        String uname = getIntent().getStringExtra("keyname");
        String uemail = getIntent().getStringExtra("keyemail");

        name.setText(uname);
        email.setText(uemail);

    }
}

