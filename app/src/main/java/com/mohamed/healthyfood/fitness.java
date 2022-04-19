package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fitness extends AppCompatActivity implements View.OnClickListener {

    public CardView cardBMI, cardWater, cardIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        cardBMI = (CardView) findViewById(R.id.BMICalc);
        cardBMI.setOnClickListener(this);

        cardWater = (CardView) findViewById(R.id.Water);
        cardWater.setOnClickListener(this);

        cardIdeal = (CardView) findViewById(R.id.idealWeight);
        cardIdeal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.BMICalc:
                intent = new Intent(this, BMI_Calculator.class);
                startActivity(intent);
                break;
            case R.id.Water:
                intent = new Intent(this, water.class);
                startActivity(intent);
                break;
            case R.id.idealWeight:
                intent = new Intent(this, idealWeight.class);
                startActivity(intent);
                break;
        }
    }
}