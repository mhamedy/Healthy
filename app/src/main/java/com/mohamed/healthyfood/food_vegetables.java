package com.mohamed.healthyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohamed.healthyfood.adpter.VegetabelsAdpter;
import com.mohamed.healthyfood.module.FruitModule;

import java.util.ArrayList;

public class food_vegetables extends AppCompatActivity  {

  //  public CardView cardTomato, cardCarrot, cardPepper, cardOnion, cardPotatoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_vegetables);
/*
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
*/
        RecyclerView recyclerView = findViewById(R.id.recycle_vegetables);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new VegetabelsAdpter());
    }


    /*@Override
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
    }*/
}