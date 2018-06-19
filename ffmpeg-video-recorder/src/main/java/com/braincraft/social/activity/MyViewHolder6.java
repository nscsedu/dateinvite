package com.braincraft.social.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;


public class MyViewHolder6 extends RecyclerView.ViewHolder {

    TextView nametxt,count,age,messagetext,date,unblock;
    ImageView thumbnail;

    public MyViewHolder6(View itemView) {
        super(itemView);
        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        count= (TextView) itemView.findViewById(R.id.count);
        // age= (TextView) itemView.findViewById(R.id.age);
        messagetext= (TextView) itemView.findViewById(R.id.avilablefor);
        date= (TextView) itemView.findViewById(R.id.date);
        unblock = (TextView) itemView.findViewById(R.id.unblock);

        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
    }
}
