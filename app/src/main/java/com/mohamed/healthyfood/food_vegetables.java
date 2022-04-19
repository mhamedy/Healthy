package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class food_vegetables extends AppCompatActivity implements View.OnClickListener {

    public CardView cardTomato, cardCarrot, cardPepper, cardOnion, cardPotatoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_vegetables);

        cardTomato = (CardView) findViewById(R.id.Tomatoes);
        cardTomato.setOnClickListener(this);

        cardCarrot = (CardView) findViewById(R.id.carrots);
        cardCarrot.setOnClickListener(this);

        cardPepper = (CardView) findViewById(R.id.pepper);
        cardPepper.setOnClickListener(this);

        cardOnion = (CardView) findViewById(R.id.onion);
        cardOnion.setOnClickListener(this);

        cardPotatoes = (CardView) findViewById(R.id.potatoes);
        cardPotatoes.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.Tomatoes:
                intent = new Intent(this, vTomato.class);
                startActivity(intent);
                break;

            case R.id.carrots:
                intent = new Intent(this, vCarrots.class);
                startActivity(intent);
                break;

            case R.id.pepper:
                intent = new Intent(this, vPepper.class);
                startActivity(intent);
                break;

            case R.id.onion:
                intent = new Intent(this, vonion.class);
                startActivity(intent);
                break;

            case R.id.potatoes:
                intent = new Intent(this, vpotatoes.class);
                startActivity(intent);
                break;
        }
    }
}