package com.mohamed.healthyfood.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohamed.healthyfood.R;
import com.mohamed.healthyfood.module.SportsModule;

import java.util.ArrayList;

public class SportsAdpter extends RecyclerView.Adapter<SportsAdpter.SportsViewHolder>{

    ArrayList<SportsModule> sportsModules ;
    DatabaseReference reference;

    public SportsAdpter(){

        reference = FirebaseDatabase.getInstance().getReference("sports");
        sportsModules = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot item : snapshot.getChildren()){
                        SportsModule module = item.getValue(SportsModule.class);
                        sportsModules.add(module);
                        notifyItemChanged(sportsModules.size()-1);
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
    public SportsAdpter.SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sports_row_layout,parent,false);
        return new SportsAdpter.SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdpter.SportsViewHolder holder, int position) {
        holder.bulidUI(sportsModules.get(position));
    }

    @Override
    public int getItemCount() {
        return sportsModules.size();
    }
    public class SportsViewHolder extends RecyclerView.ViewHolder{
        TextView nameSports  , infoSports;
        public SportsViewHolder(@NonNull View itemView){
            super(itemView);
            nameSports = itemView.findViewById(R.id.name_sports);
            infoSports = itemView.findViewById(R.id.info_sports);

        }
        public void bulidUI(SportsModule module){
            nameSports.setText(module.getSport_name());
            infoSports.setText(module.getInfo_sport());
        }
    }
}

