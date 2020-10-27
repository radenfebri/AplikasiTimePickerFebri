package com.example.timepickerfebri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private TextView TimeTextView;
    private Button Picktime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeTextView=findViewById(R.id.timetextview);
        Picktime=findViewById(R.id.picktime);

    Picktime.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Calendar calendar=Calendar.getInstance();
            int hours=calendar.get(Calendar.HOUR_OF_DAY);
            int mins=calendar.get(calendar.MINUTE);
            TimePickerDialog timePickerDialog= new TimePickerDialog(MainActivity.this, R.style.Theme_AppCompat_DayNight_Dialog, new TimePickerDialog.OnTimeSetListener() {
                @Override
             public void onTimeSet(TimePicker view, int hourofDay, int minute) {
                  Calendar c=Calendar.getInstance();
                  c.set(calendar.HOUR_OF_DAY,hourofDay);
                  c.set(Calendar.MINUTE,minute);
                  c.setTimeZone(TimeZone.getDefault());
                  SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                  String time = format.format(c.getTime());
                  TimeTextView.setText(time);
                }

                },hours ,mins, false);
                    timePickerDialog.show();

        }
    });
    }
}