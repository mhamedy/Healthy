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
import com.mohamed.healthyfood.module.MushroomModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MushroomAdpter extends RecyclerView.Adapter<MushroomAdpter.MushroomViewHolder> {

    ArrayList<MushroomModule> mushroomModules ;
    DatabaseReference reference;
    public MushroomAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("mushroom");
        mushroomModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        MushroomModule module = item.getValue(MushroomModule.class);
                        mushroomModules.add(module);
                        notifyItemChanged(mushroomModules.size()-1);
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
    public MushroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mushroom_row_layout,parent,false);
        return new MushroomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MushroomViewHolder holder, int position) {
            holder.bulidUI(mushroomModules.get(position));
    }

    @Override
    public int getItemCount() {
        return mushroomModules.size();
    }

    public class MushroomViewHolder extends RecyclerView.ViewHolder{
        ImageView imageVegetables;
        TextView nameVegrtables  , infoVegrtables;
        public MushroomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVegetables = itemView.findViewById(R.id.image_mushroom);
            nameVegrtables = itemView.findViewById(R.id.name_mushroom);
            infoVegrtables = itemView.findViewById(R.id.info_mushroom);
        }

        public void bulidUI(MushroomModule module){
            nameVegrtables.setText(module.getName_mush());
            infoVegrtables.setText(module.getInfo_mush());
            if(module.getImage_mush()!=null) showImage(module.getImage_mush());
        }
        private void showImage(String url) {
            if (url != null && url.isEmpty() == false) {
                int width = Resources.getSystem().getDisplayMetrics().widthPixels;
                Picasso.get().load(url).resize(width, width)
                        .centerCrop()
                        .into(imageVegetables);
            }
        }
    }
}
