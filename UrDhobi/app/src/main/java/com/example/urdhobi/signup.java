package com.example.urdhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

public class signup extends AppCompatActivity {
    EditText getting_otp;
    Button send_otp;
    double otp;
    String sh;
    int i;
    String sotp;
    String s="";
    String generator;
    int length=5;
    int range=9;
    String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if (android.os.Build.VERSION.SDK_INT>=24)
        {
            StrictMode.ThreadPolicy policy= new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getting_otp=findViewById(R.id.get_otp);
        send_otp=findViewById(R.id.otp_button);

        send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateOtp();

                try {
                    sotp=getting_otp.getText().toString();
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
                try {
                    URL urlStr = new URL("https://www.fast2sms.com/dev/bulk?authorization=mUbICBVzWQf4jy2hRZDHdO0EYoascMiFP1qkuwANgT8L365Jt7HUjzn1iT9NB0YmGpV7MwtWaLFfXlPQ&sender_id=FSTSMS&language=english&route=qt&variables=%7bAA%7d&message=15439&variables_values="+ URLEncoder.encode(generator,"UTF-8")+"&numbers=" + URLEncoder.encode(sotp,"UTF-8"));
                    Uri uri=Uri.parse(urlStr.toURI().toString());

                    sh=uri.toString();
                }catch (MalformedURLException | URISyntaxException | UnsupportedEncodingException e1){
                    e1.printStackTrace();
                }
                OtpGone();

                Intent i=new Intent(signup.this,otpPage.class);
                i.putExtra("MyKey",generator);
                i.putExtra("number",sotp);
                startActivity(i);
                finish();


            }
        });



    }
    public void OtpGone(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, sh, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response from server" + response.toLowerCase());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }


        );

        requestQueue.add(stringRequest);
    }
    public void GenerateOtp(){
        int randomNumber;
        SecureRandom secureRandom=new SecureRandom();

        for(i=0;i<length;i++){
            int number=secureRandom.nextInt(range);
            if (number == 0 && i == 0) {
                i=-1;
                continue;
            }
            s=s+number;
        }
        randomNumber=Integer.parseInt(s);
        s="0";
        generator=String.valueOf(randomNumber);
    }
}
