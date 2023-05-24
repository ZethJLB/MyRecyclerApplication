package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.widget.Toast;

public class ActivityGps extends AppCompatActivity {
    private static final String TAG = "ActivityGps.java class says...";

    Button btnShowLocation;

    private static final int REQUEST_CODE_PERMISSION = 2;

    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, REQUEST_CODE_PERMISSION);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        btnShowLocation = (Button) findViewById(R.id.activityGPSButton);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //instantiate the gps tracker class we made
                gps = new GPSTracker(ActivityGps.this);
                //check if gps is enabled
                if (gps.canGetLocation()) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

//                    Toast.makeText(getApplicationContext(), "Latitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();
                    showOnMaps(latitude,longitude);

                } else {
                    gps.showSettingsAlert();
                }
            }
        });
    }

    @Override
    protected void onStop() {

        super.onStop();
        gps.stopUsingGPS();
    }

    private void showOnMaps(Double latitude, Double longitude) {
        Intent intent = new Intent(this, ActivityMaps.class);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);


    }
}
