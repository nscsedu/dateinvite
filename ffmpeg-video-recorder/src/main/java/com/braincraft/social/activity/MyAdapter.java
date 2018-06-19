package com.braincraft.social.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.braincraft.social.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.braincraft.social.activity.Page_Activity.age_list;
import static com.braincraft.social.activity.Page_Activity.city;
import static com.braincraft.social.activity.Page_Activity.coffe_list;
import static com.braincraft.social.activity.Page_Activity.coffee_image;
import static com.braincraft.social.activity.Page_Activity.dinner_image;
import static com.braincraft.social.activity.Page_Activity.dinner_list;
import static com.braincraft.social.activity.Page_Activity.drinks_image;
import static com.braincraft.social.activity.Page_Activity.drinks_list;
import static com.braincraft.social.activity.Page_Activity.mail;
import static com.braincraft.social.activity.Page_Activity.name;
import static com.braincraft.social.activity.Page_Activity.tmp_username;
import static com.braincraft.social.activity.Page_Activity.token;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    Context c;
    ArrayList<String> spacecrafts;
    LinearLayout lrv;
    ImageView  thumbnail;
Context context;
    static int i=0;
    public static int j=0;
    public static int k=0;
    String pos;
    private ArrayList<AndroidVersion> android_versions;
    ArrayList<String> urls;

/*
    public static String[] city={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"};

    public static String[] name={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};
*/

    public MyAdapter(Context c, ArrayList<String> spacecrafts, ArrayList<String> ImgUrl/*,ArrayList<AndroidVersion> android_versions*/) {
        this.c = c;
        this.spacecrafts = spacecrafts;
       // this.android_versions = android_versions;
        this.urls = ImgUrl;

        Log.i(TAG, " this.spacecrafts:" + this.spacecrafts);
    }

    //INITIALIZE VH
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.page_model,parent,false);
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


        return new MyViewHolder(v);
    }




    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Log.i(TAG, "position1:" +position);

        Log.i(TAG, "spacecrafts.get:" +spacecrafts.get(position));
        pos=spacecrafts.get(position);
        j= Integer.parseInt(pos);
        j=j-1;
        Log.i(TAG, "pos:" + pos);
        Log.i(TAG, "j:" +j);
      //  thumbnail = (ImageView) context.findViewById(R.id.thumbnail);
        //BIND DATA
        // holder.nametxt.setText(spacecrafts.get(position));
       // holder.nametxt.setText(name[j]);
       // holder.nametxt.setText( myArray[k]);
      // Log.v("123myArray[k]:",  myArray[k]);
        k++;
        holder.nametxt.setText(name[j]);

        holder.age.setText(age_list[j]);
        //holder.nametxt.setText(tmp_username);
        Log.i(TAG, "tmp_username123:" +tmp_username);
        //holder.nametxt.setText(tmp_username);
    // holder.thumbnail.setImageResource( mArray[j]);


        Glide.with(this.c)
                .load(urls.get(j))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);


      //  Picasso.with(c).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(holder.thumbnail);

        // Glide.with(context).load("http://api.learn2crack.com/android/images/eclair.png").into(holder. thumbnail);

        // Picasso.with(context).load(android_image_urls[j].get(position)).resize(120, 60).into(holder. thumbnail);


//        Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).resize(120, 60).into(holder.thumbnail);

        // holder.thumbnail.setImageResource(http://media.dateinvite.com/122155269aba2ad247856e2f02fd4b28_mid.jpg);
      /*  Picasso.with(context)
                .load("https://www.simplifiedcoding.net/wp-content/uploads/2015/10/advertise.png")
                                      // optional
                .into(thumbnail);
*/
       // Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(thumbnail);
        /*Picasso.with(context)
                .load(android_image_urls[j])
                // optional
                .into(thumbnail);*/

       // holder.nametxt.setText(name_list.get(j));
        /*if (name_list != null) {
            holder.nametxt.setText(name_list[i]);
        }*/

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.nametxt.setText(name_list[i]);
            }
        }, 5000);*/
        Log.i(TAG, "coffe_list[j]:" +coffe_list[j]);
        Log.i(TAG, "drinks_list[j]:" +drinks_list[j]);
        Log.i(TAG, "dinner_list[j]:" +dinner_list[j]);



       if(coffe_list[j]==1)
       {
           coffee_image.setVisibility(View.VISIBLE);
       }
        if(drinks_list[j]==1)
        {
            drinks_image.setVisibility(View.VISIBLE);
        }

        if(dinner_list[j]==1)
        {
            dinner_image.setVisibility(View.VISIBLE);
        }



        holder.count.setText(city[j]);
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
                Log.i(TAG, "pos21:" + position);
                Log.i(TAG, "pos21:" + position);

                Log.i(TAG, "token:" + token);
                Log.i(TAG, "mail:" + mail);


                String tmp_username;
                tmp_username= name[position];
                Log.i(TAG, "tmp_username:" +  tmp_username);

                Log.v("token21",  token);
                Log.v("mail21",  mail);
                Intent i = new Intent(view.getContext(), InviteNew1.class);

               i.putExtra("search",tmp_username);
                i.putExtra("token",token);
                i.putExtra("mail",mail);


                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


              /*  Intent intent = new Intent(Login.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",editTextEmail.getText().toString());
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);

                startActivity(new Intent(Login.this,InviteNew.class));
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                */



               /* Intent i = new Intent(view.getContext(), InviteNew.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",editTextEmail.getText().toString());
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);*/


                //((Activity)context).finish(); ((Activity) context).finish();
                //getting the position of the item to expand it
                //  Toast.makeText(context, "test", Toast.LENGTH_LONG).show();
                // context.startActivity(new Intent(context,Invite.class));
               /* Intent i = new Intent(context, Invite.class);
                i.putExtra("pos", pos);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();*/

               /* Toast.makeText(context, "Please check the number you entered",
                        Toast.LENGTH_LONG).show();*/

            }
        });


    }


    //TOTAL NUM
    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}