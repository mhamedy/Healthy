package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mohamed.healthyfood.adpter.FishAdpter;
import com.mohamed.healthyfood.adpter.MeatAdpter;

public class food_meat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_meat);

        RecyclerView recyclerView = findViewById(R.id.recycle_meat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new MeatAdpter());
    }
}