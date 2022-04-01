package com.example.dateandtimesetting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    Button btndate,btntime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndate = (Button) findViewById(R.id.buttondate);
        btntime = (Button) findViewById(R.id.buttontime);

    }

    public void onClick(View v){
        if (v == btndate){
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                            btndate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
        if(v == btntime) {
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                            btntime.setText(hourOfDay + ":" + minute);
                        }
                    },mHour, mMinute, true);
            timePickerDialog.show();
        }
    }
}