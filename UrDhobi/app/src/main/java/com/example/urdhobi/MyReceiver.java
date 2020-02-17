package com.example.urdhobi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

import static androidx.core.content.ContextCompat.startActivity;

public class MyReceiver extends BroadcastReceiver {


    private static EditText editText;
    public void setEditText(EditText editText){
        MyReceiver.editText=editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage sms : msgs) {
                String message = sms.getMessageBody();
                String otp = message.split("is ")[1];
                editText.setText(otp);

            }

    }
}

