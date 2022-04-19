package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class water extends AppCompatActivity {

    EditText weightWater;
    TextView resultText;
    String calculationWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        weightWater = findViewById(R.id.weightWater);
        resultText = findViewById(R.id.resultText);
    }

    public void calculationWater(View view) {
        String S1 = weightWater.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float con = (float) 22.5;
        float ideaWater = (float) (weightValue / con);

        calculationWater = "The Water need for one day \n " + ideaWater +" Liters" ;
        resultText.setText(calculationWater);
    }

}