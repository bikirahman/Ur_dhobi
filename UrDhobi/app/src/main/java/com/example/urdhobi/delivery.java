package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class delivery extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        tabLayout=(TabLayout) findViewById(R.id.tablay2delivery);
        viewPager=(ViewPager)findViewById(R.id.viewpager2delivery);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbar2delivery);
        Button button=(Button)findViewById(R.id.deliverysubmitBut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(delivery.this,time.class);
                startActivity(intent);
                finish();
            }
        });
        Viewpageradapter adapter=new Viewpageradapter(getSupportFragmentManager());


        //tomorrow date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String tomorrowAsString = dateFormat.format(tomorrow);

        //day after tomorrow
        Calendar calendartom = Calendar.getInstance();
        calendartom.add(Calendar.DAY_OF_YEAR, 3);
        Date dayaftertomorrow = calendartom.getTime();
        DateFormat dateFormatdayafter = new SimpleDateFormat("dd-MMM-yyyy");
        String dayafterAsString = dateFormatdayafter.format(dayaftertomorrow);

        //day after + tomorrow
        Calendar calendartom1 = Calendar.getInstance();
        calendartom1.add(Calendar.DAY_OF_YEAR, 4);
        Date dayaftertomorrow1 = calendartom1.getTime();
        DateFormat dateFormatdayafter1 = new SimpleDateFormat("dd-MMM-yyyy");
        String dayafterAsString1 = dateFormatdayafter1.format(dayaftertomorrow1);




        adapter.AddFragment(new delfrst(),tomorrowAsString);
        adapter.AddFragment(new delsec(),dayafterAsString);
        adapter.AddFragment(new delthrd(),dayafterAsString1);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
