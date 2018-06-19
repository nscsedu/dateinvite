package com.braincraft.social.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;


public class MyViewHolder1 extends RecyclerView.ViewHolder {

    TextView nametxt,count,age,messagetext,date;
    ImageView thumbnail;

    public MyViewHolder1(View itemView) {
        super(itemView);
        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        count= (TextView) itemView.findViewById(R.id.count);
       // age= (TextView) itemView.findViewById(R.id.age);
        messagetext= (TextView) itemView.findViewById(R.id.avilablefor);
        date= (TextView) itemView.findViewById(R.id.date);

        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
    }
}
