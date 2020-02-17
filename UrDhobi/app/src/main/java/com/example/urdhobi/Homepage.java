package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Homepage extends AppCompatActivity {
    ViewFlipper viewFlipper;
    int i;
    View view;
    ImageView wash,dry,iron,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        viewFlipper=findViewById(R.id.auto_slider);

        int[] images = {R.drawable.fnew, R.drawable.snew, R.drawable.tnew};

        for (int image: images){
            flipImages(image);
        }

        wash=(ImageView)findViewById(R.id.washing);
        Intent intent=getIntent();
        final String num=intent.getStringExtra("num");
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,address.class);
                intent.putExtra("numb",num);
                startActivity(intent);
                finish();
            }
        });

        dry=(ImageView)findViewById(R.id.washing2);
        Intent intent2=getIntent();
        final String num2=intent.getStringExtra("num");
        dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,address.class);
                intent.putExtra("numb",num);
                startActivity(intent);
                finish();
            }
        });

        iron=(ImageView)findViewById(R.id.washing);
        Intent intent3=getIntent();
        final String num3=intent.getStringExtra("num");
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,address.class);
                intent.putExtra("numb",num);
                startActivity(intent);
                finish();
            }
        });

        pre=(ImageView)findViewById(R.id.washing);
        Intent intent4=getIntent();
        final String num4=intent.getStringExtra("num");
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,address.class);
                intent.putExtra("numb",num);
                startActivity(intent);
                finish();
            }
        });
    }


    public void flipImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
