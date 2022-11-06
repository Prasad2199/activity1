package com.example.mysignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText birthdate;
    Calendar myCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText username = (EditText) findViewById(R.id.username);

        MaterialButton regbtn = (MaterialButton) findViewById(R.id.submitbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                Toast.makeText(MainActivity.this,"username is"+username1,Toast.LENGTH_SHORT);
            }
        });
        birthdate=(EditText) findViewById(R.id.birthdate);
        myCalender=Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLable();
            }
        };
         birthdate.setOnClickListener(view -> {
              new DatePickerDialog(MainActivity.this,date,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();


         });

    }

    private void updateLable() {
       String myFormat="mm/dd/yy EEEE";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        birthdate.setText(dateFormat.format(myCalender.getTime()));
    }
}