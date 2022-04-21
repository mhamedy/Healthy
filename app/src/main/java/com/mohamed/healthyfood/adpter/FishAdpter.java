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
import com.mohamed.healthyfood.module.FishModule;
import com.mohamed.healthyfood.module.FruitModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FishAdpter extends RecyclerView.Adapter<FishAdpter.FishViewHolder> {

    ArrayList<FishModule> fishModules ;
    DatabaseReference reference;
    public FishAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("fish");
        fishModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        FishModule module = item.getValue(FishModule.class);
                        fishModules.add(module);
                        notifyItemChanged(fishModules.size()-1);
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
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fish_row_layout,parent,false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
            holder.bulidUI(fishModules.get(position));
    }

    @Override
    public int getItemCount() {
        return fishModules.size();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder{
        ImageView imageFish;
        TextView nameFish  , infoFish, recipesFish, textureFish;
        public FishViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFish = itemView.findViewById(R.id.image_fish);
            nameFish = itemView.findViewById(R.id.name_fish);
            infoFish = itemView.findViewById(R.id.info_fish);
            recipesFish = itemView.findViewById(R.id.recipes);
            textureFish = itemView.findViewById(R.id.texture);

        }

        public void bulidUI(FishModule module){
            nameFish.setText(module.getName_fish());
            infoFish.setText(module.getInfo_fish());
            recipesFish.setText(module.getRecipes());
            textureFish.setText(module.getTexture());
            if(module.getImage_fish()!=null) showImage(module.getImage_fish());
        }
        private void showImage(String url) {
            if (url != null && url.isEmpty() == false) {
                int width = Resources.getSystem().getDisplayMetrics().widthPixels;
                Picasso.get().load(url).resize(width, width)
                        .centerCrop()
                        .into(imageFish);
            }
        }
    }
}
