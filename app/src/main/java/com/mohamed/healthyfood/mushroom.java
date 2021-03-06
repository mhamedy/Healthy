package com.mohamed.healthyfood;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mohamed.healthyfood.adpter.FruitsAdpter;
import com.mohamed.healthyfood.adpter.MushroomAdpter;

public class mushroom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom);

        RecyclerView recyclerView = findViewById(R.id.recycle_mushroom);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new MushroomAdpter());
    }
}