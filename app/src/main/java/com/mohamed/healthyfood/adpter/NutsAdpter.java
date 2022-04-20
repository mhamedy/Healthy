package com.mohamed.healthyfood.adpter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohamed.healthyfood.R;
import com.mohamed.healthyfood.module.FruitModule;
import com.mohamed.healthyfood.module.NutsModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NutsAdpter extends RecyclerView.Adapter<NutsAdpter.NutsViewHolder> {

    ArrayList<NutsModule> nutsModules ;
    DatabaseReference reference;
    public NutsAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("nuts");
        nutsModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        NutsModule module = item.getValue(NutsModule.class);
                        nutsModules.add(module);
                        notifyItemChanged(nutsModules.size()-1);
                    }
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });

    }
    @NonNull
    @Override
    public NutsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nuts_row_layout,parent,false);
        return new NutsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NutsViewHolder holder, int position) {
            holder.bulidUI(nutsModules.get(position));
    }

    @Override
    public int getItemCount() {
        return nutsModules.size();
    }

    public class NutsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageNuts;
        TextView nameNuts , infoNuts, caloriesNuts, fatNuts, proteinNuts,
                carbsNuts, fiberNuts, vitaminNuts, magnesiumNuts, manganeseNuts, info2Nuts;
        public NutsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNuts = itemView.findViewById(R.id.name_nuts);
            imageNuts = itemView.findViewById(R.id.image_nuts);
            caloriesNuts = itemView.findViewById(R.id.name_calories);
            fatNuts = itemView.findViewById(R.id.name_fat);
            proteinNuts = itemView.findViewById(R.id.name_protein);
            carbsNuts = itemView.findViewById(R.id.name_carbs);
            fiberNuts = itemView.findViewById(R.id.name_fiber);
            vitaminNuts = itemView.findViewById(R.id.name_vitamin);
            magnesiumNuts = itemView.findViewById(R.id.name_magnesium);
            manganeseNuts = itemView.findViewById(R.id.name_manganese);
            info2Nuts = itemView.findViewById(R.id.info2_nuts);
            infoNuts = itemView.findViewById(R.id.info_nuts);
        }

        public void bulidUI(NutsModule module){
            nameNuts.setText(module.getName());

            caloriesNuts.setText(module.getCalories());
            fatNuts.setText(module.getFat());
            proteinNuts.setText(module.getProtein());
            carbsNuts.setText(module.getCarbs());
            fiberNuts.setText(module.getFiber());
            vitaminNuts.setText(module.getVitamin());
            magnesiumNuts.setText(module.getMagnesium());
            manganeseNuts.setText(module.getManganese());
            info2Nuts.setText(module.getInfo2());

            infoNuts.setText(module.getInfo());
            if(module.getImage()!=null) showImage(module.getImage());
        }
        private void showImage(String url) {
            if (url != null && url.isEmpty() == false) {
                int width = Resources.getSystem().getDisplayMetrics().widthPixels;
                Picasso.get().load(url).resize(width, width)
                        .centerCrop()
                        .into(imageNuts);
            }
        }
    }
}
