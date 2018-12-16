package com.example.wa697.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    protected Button btnHospital, btnDetailHospital, btnMap, btnDial, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionRequester.Builder
                request = new PermissionRequester.Builder(this);
        request.create().request(
                Manifest.permission.RECEIVE_SMS,
                10000,
                new PermissionRequester.OnClickDenyButtonListener() {
                    @Override
                    public void onClick(Activity activity) {
                        Toast.makeText(MainActivity.this,"권한을 얻지 못했습니다.",Toast.LENGTH_SHORT).show();
                    }
                }

        );

        btnHospital = (Button) findViewById(R.id.btnHospital);
        btnHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityHospital.class);
                startActivity(intent);
            }
        });

        btnDetailHospital = (Button) findViewById(R.id.btnDetailHospital);
        btnDetailHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailHospital.class);
                startActivity(intent);
            }
        });

        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/"));
                startActivity(intent);
            }
        });

        btnDial = (Button) findViewById (R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(intent);
            }
        });

        btnSms = (Button) findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
                startActivity(intent);
            }
        });
    }
}
