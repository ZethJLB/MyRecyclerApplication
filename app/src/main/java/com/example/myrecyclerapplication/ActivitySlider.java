package com.example.myrecyclerapplication;

import static java.lang.Math.round;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.slider.Slider;

public class ActivitySlider extends AppCompatActivity {
    public final static String TAG = "From ActivitySlider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        Slider mySelector = findViewById(R.id.activitySliderSelect);
//        mySelector.setStepSize(2);
//        mySelector.setValueTo(300);
//        mySelector.setValueFrom(4);
//        mySelector.setValue(100);

        mySelector.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                Log.d(TAG, String.valueOf(round(value)));
                Button button = findViewById(R.id.activitySliderButton);
                button.setText(String.valueOf(round(value)));
                rotateButton(value);
            }
        });
    }
    public void rotateButton(Float f){
        Button button = findViewById(R.id.activitySliderButton);
        button.setRotation(f);
    }
}
