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
import com.mohamed.healthyfood.module.MeatModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MeatAdpter extends RecyclerView.Adapter<MeatAdpter.MeatViewHolder> {

    ArrayList<MeatModule> meatModules ;
    DatabaseReference reference;
    public MeatAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("meat");
        meatModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        MeatModule module = item.getValue(MeatModule.class);
                        meatModules.add(module);
                        notifyItemChanged(meatModules.size()-1);
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
    public MeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meat_row_layout,parent,false);
        return new MeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeatViewHolder holder, int position) {
        holder.bulidUI(meatModules.get(position));
    }

    @Override
    public int getItemCount() {
        return meatModules.size();
    }

    public class MeatViewHolder extends RecyclerView.ViewHolder{
        ImageView imageFish;
        TextView nameFish  , infoFish, recipesFish, textureFish;
        public MeatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFish = itemView.findViewById(R.id.image_meat);
            nameFish = itemView.findViewById(R.id.name_meat);
            infoFish = itemView.findViewById(R.id.info_meat);
            recipesFish = itemView.findViewById(R.id.text_calorie);
            textureFish = itemView.findViewById(R.id.protein_meat);

        }

        public void bulidUI(MeatModule module){
            nameFish.setText(module.getName_meat());
            infoFish.setText(module.getInfo_meat());
            recipesFish.setText(module.getCalories());
            textureFish.setText(module.getProtein());
            if(module.getImage_meat()!=null) showImage(module.getImage_meat());
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
