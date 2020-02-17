package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pickup extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);
        Button button=(Button)findViewById(R.id.pickcon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(pickup.this,time.class);
                startActivity(intent);
                finish();
            }
        });

        //Today date
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        //tomorrow date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String tomorrowAsString = dateFormat.format(tomorrow);

        //day after tomorrow
        Calendar calendartom = Calendar.getInstance();
        calendartom.add(Calendar.DAY_OF_YEAR, 2);
        Date dayaftertomorrow = calendartom.getTime();
        DateFormat dateFormatdayafter = new SimpleDateFormat("dd-MMM-yyyy");
        String dayafterAsString = dateFormatdayafter.format(dayaftertomorrow);



        tabLayout=(TabLayout) findViewById(R.id.tablay1);
        viewPager=(ViewPager)findViewById(R.id.viewpager1);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbar1);
        Viewpageradapter adapter=new Viewpageradapter(getSupportFragmentManager());

        adapter.AddFragment(new today(),formattedDate);
        adapter.AddFragment(new tomorrow(),tomorrowAsString);
        adapter.AddFragment(new dayaftertom(),dayafterAsString);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
