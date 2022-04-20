package com.mohamed.healthyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mohamed.healthyfood.adpter.FruitsAdpter;
import com.mohamed.healthyfood.adpter.NutsAdpter;

public class food_nuts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuts);

        RecyclerView recyclerView = findViewById(R.id.recycle_nuts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new NutsAdpter());
    }
}