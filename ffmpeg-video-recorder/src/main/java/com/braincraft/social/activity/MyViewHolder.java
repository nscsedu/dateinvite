package com.braincraft.social.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;

import static com.braincraft.social.activity.Page_Activity.coffee_image;
import static com.braincraft.social.activity.Page_Activity.dinner_image;
import static com.braincraft.social.activity.Page_Activity.drinks_image;


public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt,count,age;
    ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
            count= (TextView) itemView.findViewById(R.id.count);

            age= (TextView) itemView.findViewById(R.id.age);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);

            coffee_image= (Button) itemView.findViewById(R.id.coffee_image);
            dinner_image=(Button)  itemView.findViewById(R.id.dinner_image);
            drinks_image=(Button) itemView.findViewById(R.id.drinks_image);

            coffee_image.setVisibility(View.GONE);
            dinner_image.setVisibility(View.GONE);
            drinks_image.setVisibility(View.GONE);
        }
}
