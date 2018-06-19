package com.braincraft.social.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.braincraft.social.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.braincraft.social.activity.Page_Activity.name;
import static com.braincraft.social.activity.Page_Activity3.mail;
import static com.braincraft.social.activity.Page_Activity3.token;
//import static com.braincraft.social.activity.Page_Activity3.itemcount;
import static com.braincraft.social.activity.Page_Activity3.age1_list;
import static com.braincraft.social.activity.Page_Activity3.city1;
import static com.braincraft.social.activity.Page_Activity3.date_list;
import static com.braincraft.social.activity.Page_Activity3.message;
import static com.braincraft.social.activity.Page_Activity3.name1;
import static com.braincraft.social.activity.Page_Activity3.image_list;
import static com.braincraft.social.activity.Page_Activity3.name11;

public class MyAdapter3 extends RecyclerView.Adapter<MyViewHolder3>  {
    Context c;
    ArrayList<String> spacecrafts;
    LinearLayout lrv;
    ImageView  thumbnail;
    Context context;
    static int i=0;
    public static int j=0;
    String pos;
    int[] mArray = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6
            ,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9};

    ArrayList<String> urls;

    public static int itemcountadapter=0;
    int elemnet;
    public static int itemflag=0;


    static int cnt=0;
    int itcount;

    public MyAdapter3(Context c, ArrayList<String> spacecrafts,ArrayList<String> ImgUrl,int itemcount) {
        this.c = c;
        this.spacecrafts = spacecrafts;
this.itcount=itemcount;
        this.urls = ImgUrl;
        Log.i(TAG, " this.spacecrafts:" + this.spacecrafts);
    }

    //INITIALIZE VH
    @Override
    public MyViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.liked_me_new,parent,false);
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


        return new MyViewHolder3(v);
    }




    @Override
    public void onBindViewHolder(MyViewHolder3 holder,final int position) {

        Log.i(TAG, "position:" + i);

        Log.i(TAG, "spacecrafts.get:" + spacecrafts.get(position));
        pos = spacecrafts.get(position);
        j = Integer.parseInt(pos);
        j = j - 1;
        Log.i(TAG, "pos:" + pos);
        Log.i(TAG, "size:" + urls.size());
        Log.i(TAG, "j:" + j);
        //  thumbnail = (ImageView) context.findViewById(R.id.thumbnail);
        //BIND DATA
        // holder.nametxt.setText(spacecrafts.get(position));
        // holder.thumbnail.setImageResource( mArray[j]);
        cnt = cnt - 1;
        Log.i(TAG, "image_listsize:" + image_list.size());

        cnt++;
        if (j < image_list.size()) {
            Glide.with(this.c)
                    .load(image_list.get(j))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.thumbnail);
        //holder.thumbnail.setImageResource( mArray[j]);
            holder.nametxt.setText(name1[j]);
            // holder.age.setText(age1_list[j]);
            holder.count.setText(city1[j]);
            holder.messagetext.setText(message[j]);
            holder.date.setText(date_list[j]);
       }
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

               /* Intent i = new Intent(view.getContext(), Invite.class);

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

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


            }
        });
        holder.count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  Intent i = new Intent(view.getContext(), Invite.class);

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

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


            }
        });
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Toast.makeText(view.getContext(), "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/
               /* Intent i = new Intent(view.getContext(), Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/



               /* String tmp_username;
                tmp_username= name[position];
                Log.i(TAG, "tmp_username:" +  tmp_username);
                Intent i = new Intent(view.getContext(), InviteNew1.class);

                i.putExtra("search",tmp_username);


                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/





/*
                String tmp_username;
                tmp_username=name1[position];
                Log.i(TAG, "tmp_username123:" +  tmp_username);
                Intent i = new Intent(view.getContext(), InviteNew1.class);

                i.putExtra("search",tmp_username);


                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/
              /*  String tmp_username;
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

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/
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
        holder.likedme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent i = new Intent(view.getContext(), Invite.class);

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

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


            }
        });


    }


    //TOTAL NUM
    @Override
    public int getItemCount() {

     /*   Log.i(TAG, "itemcountadapter:" + itemcountadapter);
        Log.i(TAG, "itemcount:" + itemcount);
        Log.i(TAG, " elemnet:" +  elemnet);

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
}