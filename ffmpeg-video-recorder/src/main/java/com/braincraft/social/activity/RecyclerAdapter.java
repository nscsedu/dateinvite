package com.braincraft.social.activity;

/**
 * Created by ADMIN on 25/5/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import static com.braincraft.social.activity.infinite_main.ImgUrl;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    //public static ArrayList<String> urls;
    private ArrayList<RecyclerModel> recyclerModels; // this data structure carries our title and description
    Context c;
   // c=RecyclerAdapter.this;
    public RecyclerAdapter(/*Context c,*/ArrayList<RecyclerModel> recyclerModels/*,ArrayList<String> ImgUrl*/) {
       // this.c = c;
        this.recyclerModels = recyclerModels;
       // this.urls = ImgUrl;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate your custom row layout here
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.page_model, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        // update your data here

        holder.title.setText(recyclerModels.get(position).getTitle());
        holder.description.setText(recyclerModels.get(position).getDescription());

       // holder.thumbnail.setText(recyclerModels.get(position).getLocation());
       Glide.with(holder.thumbnail.getContext())
                .load(ImgUrl.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
        //Glide.with(c).load(recyclerModels.get(position).getThumbnail()).into(holder.thumbnail);
      /*  Picasso.with(holder.thumbnail.getContext()).load(recyclerModels.get(position).getThumbnail())
                .resize(96, 96).centerCrop().into(holder.thumbnail);*/

        holder.count.setText(recyclerModels.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here
        private TextView title;
        private TextView description;
        private TextView count;
        private ImageView thumbnail;

        MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.age);
            description = (TextView) view.findViewById(R.id.count);
           count= (TextView) view.findViewById(R.id.nameTxt);
           thumbnail= (ImageView) view.findViewById(R.id.thumbnail);

        }
    }
}