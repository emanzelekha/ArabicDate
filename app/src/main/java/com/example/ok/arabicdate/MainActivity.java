package com.example.ok.arabicdate;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.alhazmy13.hijridatepicker.HijriCalendarDialog;
import net.alhazmy13.hijridatepicker.HijriCalendarView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements HijriCalendarView.OnDateSetListener {
Button Date;

    HijriCalendarDialog.Builder text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date=(Button)findViewById(R.id.Date);

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Dialog();
            }
        });
    }

    @Override
    public void onDateSet(int year, int month, int day) {
        NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));//formate
        String year1=  nf.format(year);
        String month1=  nf.format(month+1);
        String day1=  nf.format(day);
        Toast.makeText(getApplicationContext(),year1+"/"+month1+"/"+day1, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),nf.format(1345), Toast.LENGTH_SHORT).show();
    }
    public void Dialog(){
        text= new HijriCalendarDialog.Builder(this).setUILanguage(HijriCalendarDialog.Language.Arabic).setOnDateSetListener(this).show();

    }
}
