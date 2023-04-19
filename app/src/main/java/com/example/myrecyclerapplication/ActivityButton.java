package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityButton extends AppCompatActivity {

    private EditText integerOne, integerTwo, result;
    private Button makeProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        addButtonListener();
    }

    private void addButtonListener() {
        integerOne = findViewById(R.id.activityButtonInputOneEditText);
        integerTwo = findViewById(R.id.activityButtonInputTwoEditText);
        makeProduct = findViewById(R.id.activityButtonButton);
        result = findViewById(R.id.activityButtonResultEditText);

        makeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(integerOne.getText().toString());
                int b = Integer.parseInt(integerTwo.getText().toString());

                result.setText(String.valueOf(a*b));
            }
        });


        }
    }
