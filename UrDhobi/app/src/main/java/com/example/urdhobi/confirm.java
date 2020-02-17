package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class confirm extends AppCompatActivity {
    int menf,mens,ment;
    int wmf,wms,wmt;
    int cf,cs,ct;
    Button accept,reject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        accept=(Button)findViewById(R.id.acceptBut);
        reject=(Button)findViewById(R.id.rejectBut);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(confirm.this,Thankyou.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
