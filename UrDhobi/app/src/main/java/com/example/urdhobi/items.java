package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class items extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button button;
    private AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        tabLayout=(TabLayout) findViewById(R.id.itemsTab);
        viewPager=(ViewPager)findViewById(R.id.itemsviewpager1);
        button=(Button)findViewById(R.id.itembutton);
        Viewpageradapter adapter=new Viewpageradapter(getSupportFragmentManager());

        adapter.AddFragment(new men(),"Men");
        adapter.AddFragment(new women(),"Women");
        adapter.AddFragment(new children(),"Children");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(items.this,confirm.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
