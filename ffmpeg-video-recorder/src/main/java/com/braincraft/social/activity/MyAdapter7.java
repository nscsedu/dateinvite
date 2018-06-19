package com.braincraft.social.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.braincraft.social.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.braincraft.social.activity.chatmessage.mail;
import static com.braincraft.social.activity.Page_Activity.name;
import static com.braincraft.social.activity.chatmessage.sendid;
import static com.braincraft.social.activity.chatmessage.token;
//import static com.braincraft.social.activity.chatmessage.itemcount;
import static com.braincraft.social.activity.Page_Activity1.age1_list;
import static com.braincraft.social.activity.chatmessage.city1;
import static com.braincraft.social.activity.chatmessage.date_list;
import static com.braincraft.social.activity.chatmessage.message;
import static com.braincraft.social.activity.chatmessage.name1;
import static com.braincraft.social.activity.chatmessage.image_list;
import static com.braincraft.social.activity.chatmessage.name11;

public class MyAdapter7 extends RecyclerView.Adapter<MyViewHolder7>  {
    Context c;
    ArrayList<String> spacecrafts;
    LinearLayout lrv;
    ImageView  thumbnail,seen;
    Context context;
    static int i=0;
    public static int j=0;
    String pos;
    int[] mArray = {R.drawable.small_card_coffee_es,R.drawable.card_drink_en,R.drawable.small_card_dinner_en,R.drawable.album6,R.drawable.album9};

    ArrayList<String> urls;
int itcount;
    public static int itemcountadapter=0;
    int elemnet;
    public static int itemflag=0;
    Activity activity = (Activity) context;
Context contex;
    static int cnt=0;

    public MyAdapter7(Context c, ArrayList<String> spacecrafts,ArrayList<String> ImgUrl,int itemcount) {
        this.c = c;
        this.spacecrafts = spacecrafts;
this.itcount=itemcount;
        this.urls = ImgUrl;
        Log.i(TAG, " this.spacecrafts:" + this.spacecrafts);
    }

    //INITIALIZE VH
    @Override
    public MyViewHolder7 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.automessage,parent,false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // item clicked
                Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);


            }
        });



        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //  perfoem your action here
                Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);
            }
        });


        return new MyViewHolder7(v);
    }




    @Override
    public void onBindViewHolder(MyViewHolder7 holder, final int position) {

       // Log.i(TAG, "position:" + i);

       // Log.i(TAG, "spacecrafts.get:" + spacecrafts.get(position));
       // pos = spacecrafts.get(position);
    //    j = Integer.parseInt(pos);
      //  j = j - 1;
        Log.i(TAG, "pos123:" + date_list[position]);
        Log.i(TAG, "size:" + urls.size());
        Log.i(TAG, "name11:" + name11[position]);
        String s = name11[position];
        String s1 = s.substring(s.indexOf("]")+1);
        s1=s1.trim();
        //  thumbnail = (ImageView) context.findViewById(R.id.thumbnail);
        //BIND DATA
        // holder.nametxt.setText(spacecrafts.get(position));
        // holder.thumbnail.setImageResource( mArray[j]);
        cnt = cnt - 1;
        Log.i(TAG, "image_listsize:" + image_list.size());

        cnt++;


        holder.nametxt.setText(s1);

        holder.messagetext.setText(date_list[position]);
       if(sendid!= Integer.parseInt(city1[position]))
       {  // seen.setVisibility(View.GONE);



           holder.seen.setVisibility(View.VISIBLE);
          // holder.likedtoother.setBackgroundColor(Color.parseColor("#F0E68C"));
           holder.cardcolor.setBackgroundColor(Color.parseColor("#F0E68C"));
          // holder.likedtoother.setPadding(130,0,0,0);
           //holder.likedtoother.setMargins(_20, _20, _20, _20);
          //holder.likedtoother.setMargins(16, 16, 16, 16);
          // holder.likedtoother.set
           ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) holder.likedtoother.getLayoutParams();
           mlp.setMargins(100, 20, 20, 20);
           holder.likedtoother.setRadius(25);
       }
       else
       { holder.seen.setVisibility(View.GONE);
          // holder.likedtoother.setBackgroundColor(Color.parseColor("#FFFFFF"));
           holder.cardcolor.setBackgroundColor(Color.parseColor("#FFFFFF"));
           ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) holder.likedtoother.getLayoutParams();
           mlp.setMargins(20, 20, 100, 20);
           holder.likedtoother.setRadius(25);
          // holder.likedtoother.setPadding(0,0,130,0);
       }


        if (name11[position].toLowerCase().contains("coffee"))
        {
            Glide.with(this.c)
                    .load(mArray[0])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.thumbnail);
      }
       else if (name11[position].toLowerCase().contains("drink"))
        {
            Glide.with(this.c)
                    .load(mArray[1])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.thumbnail);
        }
        else if (name11[position].toLowerCase().contains("dinner"))
        {
            Glide.with(this.c)
                    .load(mArray[2])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.thumbnail);
        }
        else
        {//holder.likedtoother.setBackgroundColor(Color.parseColor("#F0E68C"));
           /* thumbnail.getLayoutParams().height = 1;

            // Apply the new width for ImageView programmatically
            thumbnail.getLayoutParams().width = 1;*/

        }
       // holder.messagetext.setText(name11[position]);


        i++;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "onclickk here" + i);
              /*  Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/

               /* Toast.makeText(context, "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/

               /* Toast.makeText(v.getContext(), "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/

               /* Intent intent= new Intent(context,Invite.class);

                context.startActivity(intent);*/


                //  v.getContext().startActivity(new Intent(context,Invite.class));
            }
        }) ;
        holder.nametxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);

                ((Activity) view.getContext()).finish();


            }
        });
        holder.count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Toast.makeText(view.getContext(), "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/
               /* Log.i(TAG, "pos21:" + position);

                Intent i = new Intent(view.getContext(), Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/





                String tmp_username;
                tmp_username= name11[position];
                Log.i(TAG, "tmp_username123:" +  tmp_username);


                String str ="abc,cde,def,fgh";
                String kept = str.substring( 0, str.indexOf(","));
                String remainder = str.substring(str.indexOf(",")+1, str.length());
                Log.i(TAG, "remainder:" +  remainder);
                Log.i(TAG, "remainder:" +  remainder);
                Intent i = new Intent(view.getContext(), InviteNew1.class);

                i.putExtra("search",tmp_username);
                i.putExtra("token",token);
                i.putExtra("mail",mail);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line
              //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();
             //  activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //((Activity)context).finish(); ((Activity) context).finish();
                //getting the position of the item to expand it
                //  Toast.makeText(context, "test", Toast.LENGTH_LONG).show();
                // context.startActivity(new Intent(context,Invite.class));
               /* Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/

               /* Toast.makeText(context, "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/

            }
        });

        //setFadeAnimation(holder.itemView);
    }


    //TOTAL NUM
    @Override
    public int getItemCount() {

        /*Log.i(TAG, "itemcountadapter:" + itemcountadapter);
        Log.i(TAG, "itemcount:" + itemcount);
        Log.i(TAG, "elemnet:" +  elemnet);

        Log.i(TAG, "itemflag:" +   itemflag);


        // itemcountadapter = itemcount;
        //return spacecrafts.size();
        if (itemcountadapter == 0) {
            elemnet = itemcount;

        } else {
            elemnet = itemcountadapter;
        }
        if (itemflag == 0)
        {
            itemcountadapter = itemcount;
            itemflag=itemflag+1;
        }*/
        return itcount;
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

}