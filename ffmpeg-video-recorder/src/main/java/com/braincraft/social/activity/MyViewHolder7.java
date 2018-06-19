package com.braincraft.social.activity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.braincraft.social.R;


public class MyViewHolder7 extends RecyclerView.ViewHolder {

    TextView nametxt,count,age,messagetext,date;
    ImageView thumbnail,seen;
    CardView likedtoother;
    LinearLayout cardcolor;
    public MyViewHolder7(View itemView) {
        super(itemView);
        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        count= (TextView) itemView.findViewById(R.id.count);
        // age= (TextView) itemView.findViewById(R.id.age);
        messagetext= (TextView) itemView.findViewById(R.id.avilablefor);
        date= (TextView) itemView.findViewById(R.id.date);

        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        seen = (ImageView) itemView.findViewById(R.id.seen);
//        seen.setVisibility(View.GONE);
        likedtoother=(CardView) itemView.findViewById(R.id.card_view);

        cardcolor=(LinearLayout) itemView.findViewById(R.id.cardcolor);
    }
}
