package com.example.wa697.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {

    } /*** 안드로이드에 문자메시지가 도착할 경우 실행된다.
     * @param context
     * * @param intent
     * */
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "문자메시지가 도착했습니다.", Toast.LENGTH_SHORT).show();
    }
}


