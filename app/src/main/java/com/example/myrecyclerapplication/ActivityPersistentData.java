package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityPersistentData extends AppCompatActivity {
    private TextInputEditText vesselName, vesselLength, vesselRegistration;
    private Button submitVessel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_data);

        vesselName = findViewById(R.id.activityBoatVesselName);
        vesselLength = findViewById(R.id.activityBoatVesselLength);
        vesselRegistration = findViewById(R.id.activityBoatVesselRegistration);
        submitVessel = findViewById(R.id.activityPersistentDataButton);

        submitVessel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVesselData();

            }

        });
        onResume();
        //TODO add way to reverse the read and place text into UI EditText
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("PersistentVesselData", MODE_PRIVATE);
        String savedVesselName = sharedPreferences.getString("vesselName", "");
        String savedVesselLength = sharedPreferences.getString("vesselLength", "");
        String savedVesselRegistration = sharedPreferences.getString("vesselRegistration", "");

        vesselName.setText(savedVesselName);
        vesselLength.setText(savedVesselLength);
        vesselRegistration.setText(savedVesselRegistration);
    }


    public void saveVesselData(){
            SharedPreferences sharedPreferences = getSharedPreferences("PersistentVesselData",MODE_PRIVATE);
            SharedPreferences.Editor boatPrefs = sharedPreferences.edit();

            boatPrefs.putString("vesselName", vesselName.getText().toString());
            boatPrefs.putString("vesselLength", vesselLength.getText().toString());
            boatPrefs.putString("vesselRegistration", vesselRegistration.getText().toString());
            boatPrefs.apply();


    }
}