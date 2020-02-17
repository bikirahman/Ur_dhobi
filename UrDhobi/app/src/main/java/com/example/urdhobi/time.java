package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class time extends AppCompatActivity {
    DatabaseReference databaseReference;
    RelativeLayout relativeLayout,relativeLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        relativeLayout=(RelativeLayout)findViewById(R.id.pick);
        relativeLayout1=(RelativeLayout)findViewById(R.id.deliver);
        Intent intent=getIntent();
        String numbe=intent.getStringExtra("numbe");
        String add=intent.getStringExtra("address");

        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        String id=databaseReference.push().getKey().toString();

        user u=new user(id,numbe,add);
        databaseReference.child(id).setValue(u);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(time.this,pickup.class);
                startActivity(intent1);
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(time.this,delivery.class);
                startActivity(intent2);
            }
        });

        Button button=(Button)findViewById(R.id.schedbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(time.this,items.class);
                startActivity(intent1);
                finish();
            }
        });


    }
}
