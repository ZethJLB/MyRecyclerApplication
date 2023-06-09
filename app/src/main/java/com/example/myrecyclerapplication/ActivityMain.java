package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myrecyclerapplication.utils.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data to populate the recyclerview
        ArrayList<String> coreModules = new ArrayList<>();
        coreModules.add("Accelerometer");
        coreModules.add("Button");
        coreModules.add("Check Box");
        coreModules.add("GPS");
        coreModules.add("Map");
        coreModules.add("Phone Call");
        coreModules.add("Radio Button");
        coreModules.add("WebView");
        coreModules.add("Toggle");
        coreModules.add("Persistent Data");
        coreModules.add("Slider");
        coreModules.add("Remote Data");

        //Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCourseModules);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, coreModules);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(View view, int position){
//        Toast.makeText(this,"You clicked "+ adapter.getItem(position) + " on row number "+ position, Toast.LENGTH_SHORT).show();
    switch (position){
        case 0:
            //Accelerometer
            openActivityAccelerometer();
            break;
        case 1:
            //Button
            openActivityButton();
            break;
        case 2:
            //Check Box
//            openActivityCheckBox();
            break;
        case 3:
            //GPS
            openActivityGPS();
            break;
        case 4:
            //Map
            openActivityMap();
            break;
        case 5:
            //Phone Call
//            openActivityPhoneCall();
            break;
        case 6:
//            Radio Button
            openActivityRadioButton();
            break;
        case 7:
            //Web View
            openActivityWebView();
            break;
        case 8:
            //Toggle
//            openActivityToggle();
            break;
        case 9:
            //Persistent Data
            openActivityPersistentData();
            break;
        case 10:
            //Slider
            openActivitySlider();
            break;
        case 11:
            //Remote Data
            openActivityRemoteData();
            break;
    }
    }

    private void openActivityRemoteData() {
        Intent intent = new Intent(this, ActivityRemoteData.class);
        startActivity(intent);
    }

    private void openActivityWebView() {
        Intent intent = new Intent(this, ActivityWebView.class);
        startActivity(intent);
    }

    private void openActivityGPS() {
        Intent intent = new Intent(this, ActivityGps.class);
        startActivity(intent);
    }

    private void openActivityMap() {
        Intent intent = new Intent(this, ActivityMaps.class);
        startActivity(intent);
    }

    private void openActivitySlider() {
        Intent intent = new Intent(this, ActivitySlider.class);
        startActivity(intent);
    }

    private void openActivityPersistentData() {
        Intent intent = new Intent(this, ActivityPersistentData.class);
        startActivity(intent);
    }

    private void openActivityRadioButton() {
        Intent intent = new Intent(this, ActivityRadioButton.class);
        startActivity(intent);
    }

    public void openActivityAccelerometer(){
        Intent intent = new Intent(this, ActivityAccelerometer.class);
        startActivity(intent);
    }
    public void openActivityButton(){
        Intent intent = new Intent(this, ActivityButton.class);
        startActivity(intent);
    }
}