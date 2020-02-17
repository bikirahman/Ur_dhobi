package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

public class otpPage extends AppCompatActivity {
    EditText otp;
    Button b;
    String fetch;
    String VeRi;
    String number;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        otp=findViewById(R.id.verifyEdit);
        new MyReceiver().setEditText(otp);
        b=findViewById(R.id.verifyButton);
        progressDialog=new ProgressDialog(this);
        Intent intent=getIntent();
        fetch=intent.getStringExtra("MyKey");
        number=intent.getStringExtra("number");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verification();
            }
        });
    }
    public void verification(){
        progressDialog.setMessage("Verifying...");
        progressDialog.show();
        VeRi=otp.getText().toString();
        if(VeRi.equals(fetch)){
            Toast.makeText(getApplicationContext(), "Otp validated Correctly", Toast.LENGTH_SHORT).show();
            Intent in=new Intent(otpPage.this,Homepage.class);
            in.putExtra("num",number);
            progressDialog.dismiss();
            startActivity(in);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Incorrect Otp",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog!= null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
