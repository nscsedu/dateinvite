package com.braincraft.social.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 10/6/2018.
 */

public class MyViewHolder8 extends RecyclerView.ViewHolder {

    TextView nametxt,count,age,messagetext,date,videocount,seenvideo;
    ImageView thumbnail;

    public MyViewHolder8(View itemView) {
        super(itemView);
        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        count= (TextView) itemView.findViewById(R.id.count);
        // age= (TextView) itemView.findViewById(R.id.age);
        messagetext= (TextView) itemView.findViewById(R.id.date);
       // date= (TextView) itemView.findViewById(R.id.date);
        videocount= (TextView) itemView.findViewById(R.id.videocount);

        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);


        seenvideo= (TextView) itemView.findViewById(R.id.seenvideo);
    }
}