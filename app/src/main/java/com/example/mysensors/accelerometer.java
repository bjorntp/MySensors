package com.example.mysensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class accelerometer extends AppCompatActivity implements SensorEventListener {

    TextView xString, yString, zString, lutning;
    private float xValue, yValue, zValue;
    private SensorManager sensorManager;
    private Sensor accSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        initialValues();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accSensor, sensorManager.SENSOR_DELAY_NORMAL);

    }

    public void initialValues() {

        xValue = 0;
        yValue = 0;
        zValue = 0;

        xString = (TextView) findViewById(R.id.xView);
        yString = (TextView) findViewById(R.id.yView);
        zString = (TextView) findViewById(R.id.zView);
        lutning = (TextView) findViewById(R.id.alignment);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        xValue = (float) Math.round(sensorEvent.values[0] * 100 ) / 100;
        yValue = (float) Math.round(sensorEvent.values[1] * 100 ) / 100;
        zValue = (float) Math.round(sensorEvent.values[2] * 100 ) / 100;

        displayCurrentValues();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void displayCurrentValues() {
        xString.setText("X: " + Float.toString(xValue));
        yString.setText("Y: " + Float.toString(yValue));
        zString.setText("Z: " + Float.toString(zValue));

        if(xValue < 0.5 && xValue > -0.5) {
            lutning.setText("Lutar ej åt sidan");
        }else if (xValue > 0.5) {
            lutning.setText("Lutar åt vänster");
        } else {
            lutning.setText("Lutar åt höger");
        }
    }
}