package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityRadioButton extends AppCompatActivity {
    private static final String TAG = "ActivityRadioButton.java";
    private RadioGroup myRadioGroup;
    private TextView myStatusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        addRadioGroupListener();
//        Log.d(TAG, "Lets go programmers!");
    }

    public void addRadioGroupListener(){
        myRadioGroup = findViewById(R.id.activityRadioButtonRadioGroup);
        myStatusMessage = findViewById(R.id.activityRadioButtonResultText);
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.radioButtonActivityChoiceJava:
                        Log.d(TAG, "You like Java! Celebrate");
                        myStatusMessage.setText(R.string.activity_radio_button_love_java);
                        break;
                    case R.id.radioButtonActivityChoiceKotlin:
                        Log.d(TAG, "You like Kotlin! Celebrate");
                        myStatusMessage.setText(R.string.activity_radio_button_love_kotlin);
                        break;
                    case R.id.radioButtonActivityChoicePython:
                        Log.d(TAG, "You like Python! Celebrate");
                        myStatusMessage.setText(R.string.activity_radio_button_love_python);
                        break;
                }
            }
        });

    }
}