package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.Manifest;

public class ActivityGps extends AppCompatActivity {
    private static final String TAG = "ActivityGps.java class";

    Button btnShowLocation;

    private static final int REQUEST_CODE_PERMISSION = 2;

    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
    }
}