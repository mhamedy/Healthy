package com.mohamed.healthyfood.adpter;

import android.content.res.Resources;
import android.util.Log;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VegetabelsAdpter extends RecyclerView.Adapter<VegetabelsAdpter.VegetablresViewHolder> {

    ArrayList<FruitModule> fruitModules ;
    DatabaseReference reference;
    public VegetabelsAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("fruit");
        fruitModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        FruitModule module = item.getValue(FruitModule.class);
                        fruitModules.add(module);
                        notifyItemChanged(fruitModules.size()-1);
                    }
                    notifyDataSetChanged();
                    Log.i("aetraeytrytiuot", fruitModules.size()+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });

    }
    @NonNull
    @Override
    public VegetablresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vegetables_row_layout,parent,false);
        return new VegetablresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetablresViewHolder holder, int position) {
            holder.bulidUI(fruitModules.get(position));
    }

    @Override
    public int getItemCount() {
        return fruitModules.size();
    }

    public class VegetablresViewHolder extends RecyclerView.ViewHolder{
        ImageView imageVegetables;
        TextView nameVegrtables  , infoVegrtables;
        public VegetablresViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVegetables = itemView.findViewById(R.id.image_vegetables);
            nameVegrtables = itemView.findViewById(R.id.name_vegrtables);
            infoVegrtables = itemView.findViewById(R.id.info_vegetables);
        }

        public void bulidUI(FruitModule module){
            nameVegrtables.setText(module.getFruit_name());
            infoVegrtables.setText(module.getInfo());
            if(module.getImage_url()!=null) showImage(module.getImage_url());
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
