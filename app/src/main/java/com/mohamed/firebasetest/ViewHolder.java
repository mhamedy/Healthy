package com.mohamed.firebasetest;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setdatails(Context context, String title, String image){
        TextView mtitletv = view.findViewById(R.id.rTitleView);
        ImageView mImagetv = view.findViewById(R.id.rImageView);

        mtitletv.setText(title);
        Picasso.get().load(image).into(mImagetv);


    }

}
