package com.example.mysensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAcc(View view) {
        Intent acc = new Intent(this, accelerometer.class);
        startActivity(acc);
    }

    public void openCompass(View view) {
        Intent comp = new Intent(this, compass.class);
        startActivity(comp);
    }
}