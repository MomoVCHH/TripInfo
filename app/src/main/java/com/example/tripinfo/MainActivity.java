package com.example.tripinfo;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog userDatePicker;
    TimePickerDialog userTimePicker;
    EditText showUserDate;
    EditText showUserTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUserDate=(EditText) findViewById(R.id.enterDate);
        showUserDate.setInputType(InputType.TYPE_NULL);
        showUserDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // date picker dialog
                userDatePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                showUserDate.setText(" " + dayOfMonth + " / " + (monthOfYear + 1) + " / " + year + "  ");
                            }
                        }, year, month, day);

                        userDatePicker.show();
            }
        });

        showUserTime=(EditText) findViewById(R.id.enterTime);
        showUserTime.setInputType(InputType.TYPE_NULL);
        showUserTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldt = Calendar.getInstance();
                int hour = cldt.get(Calendar.HOUR_OF_DAY);
                int minute = cldt.get(Calendar.MINUTE);

                // time picker dialog
                userTimePicker = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                showUserTime.setText(" "+hourOfDay + " : " + minute);
                            }
                        }, hour, minute, true);

                           userTimePicker.show();
            }
        });
    }
}


