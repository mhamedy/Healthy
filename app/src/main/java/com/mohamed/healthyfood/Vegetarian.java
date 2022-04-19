package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Vegetarian extends AppCompatActivity implements View.OnClickListener {

    public CardView cardVegetables, cardFruits, cardHerbs, cardBMI,cardMushrooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian);

        cardVegetables = (CardView) findViewById(R.id.fVegetables);
        cardFruits = (CardView) findViewById(R.id.fFruits);
        cardHerbs = (CardView) findViewById(R.id.fHerbs);

        cardVegetables.setOnClickListener(this);
        cardFruits.setOnClickListener(this);
        cardHerbs.setOnClickListener(this);

        cardBMI = (CardView) findViewById(R.id.body);
        cardBMI.setOnClickListener(this);

        cardMushrooms = (CardView) findViewById(R.id.fMushroom);
        cardMushrooms.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.fVegetables:
                intent = new Intent(this,food_vegetables.class);
                startActivity(intent);
                break;

            case R.id.fFruits:
                intent = new Intent(this,food_fruits.class);
                startActivity(intent);
                break;

            case R.id.fHerbs:
                intent = new Intent(this,food_herbs.class);
                startActivity(intent);
                break;

            case R.id.body:
                intent = new Intent(this, fitness.class);
                startActivity(intent);
                break;

            case R.id.fMushroom:
                intent = new Intent(this, mushroom.class);
                startActivity(intent);
                break;
        }

    }
}