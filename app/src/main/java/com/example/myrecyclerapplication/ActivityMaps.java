package com.example.myrecyclerapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myrecyclerapplication.databinding.ActivityMapsBinding;

public class ActivityMaps extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "ActivityMaps.java";
    public Double mLatitude;
    public Double mLongitude;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLatitude = getIntent().getDoubleExtra("latitude", 0.00);
        mLongitude = getIntent().getDoubleExtra("longitude", 0.00);
        Log.d(TAG, mLatitude.toString() + " " + mLongitude.toString());
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng school = new LatLng(mLatitude, mLongitude);
        mMap.addMarker(new MarkerOptions().position(school).title("Our School"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(school));
    }
}