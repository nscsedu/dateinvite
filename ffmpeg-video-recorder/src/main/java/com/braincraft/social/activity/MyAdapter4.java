package com.braincraft.social.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
//import static com.braincraft.social.activity.Page_Activity4.itemcount;
import static com.braincraft.social.activity.Page_Activity4.age1_list;
import static com.braincraft.social.activity.Page_Activity4.city1;
import static com.braincraft.social.activity.Page_Activity4.date_list;
import static com.braincraft.social.activity.Page_Activity4.id_count;
import static com.braincraft.social.activity.Page_Activity4.mail;
import static com.braincraft.social.activity.Page_Activity4.message;
import static com.braincraft.social.activity.Page_Activity4.name1;
import static com.braincraft.social.activity.Page_Activity4.image_list;
import static com.braincraft.social.activity.Page_Activity4.token;
import static com.braincraft.social.activity.Page_Activity4.video_count;
import static com.braincraft.social.activity.Page_Activity4.video_list1;

public class MyAdapter4 extends RecyclerView.Adapter<MyViewHolder4>  {
    Context c;
    ArrayList<String> spacecrafts;
    LinearLayout lrv;
    ImageView  thumbnail;
    Context context;
    static int i=0;
    public static int j=0;
    int flag=0;
    String pos;
    int[] mArray = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6
            ,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9};

    ArrayList<String> urls;

    public static int itemcountadapter=0;
    int elemnet;
    public static int itemflag=0;

    private SharedPreferences mPreferences;
    public static SharedPreferences.Editor mEditor;

int itcount;
    static int cnt=0;

    public MyAdapter4(Context c, ArrayList<String> spacecrafts,ArrayList<String> ImgUrl,int itemcount) {
        this.c = c;
        this.spacecrafts = spacecrafts;
this.itcount=itemcount;
        this.urls = ImgUrl;
        Log.i(TAG, " this.spacecrafts:" + this.spacecrafts);
    }

    //INITIALIZE VH
    @Override
    public MyViewHolder4 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_message_new,parent,false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // item clicked
                /*Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/


            }
        });



        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //  perfoem your action here
                /*Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/
            }
        });


        return new MyViewHolder4(v);
    }




    @Override
    public void onBindViewHolder(final MyViewHolder4 holder, final int position) {

        Log.i(TAG, "position:" + i);


        if(video_list1[position]==1)
        {
            holder.reply.setText("Replied");
            holder.reply.setTextColor(Color.RED);
        }

        Log.i(TAG, "spacecrafts.get:" + spacecrafts.get(position));
        pos = spacecrafts.get(position);
        j = Integer.parseInt(pos);
        j = j - 1;
        Log.i(TAG, "id_count[j]:" + id_count[j]);
        Log.i(TAG, "size:" + urls.size());
        Log.i(TAG, "j:" + j);
        //  thumbnail = (ImageView) context.findViewById(R.id.thumbnail);
        //BIND DATA
        // holder.nametxt.setText(spacecrafts.get(position));
        // holder.thumbnail.setImageResource( mArray[j]);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(c);

        mEditor = mPreferences.edit();

        Log.v("idpos1:", String.valueOf(position));
        mEditor.putString("pos",String.valueOf(position));

        mEditor.commit();

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
            holder.videocount.setText(video_count[j]);
            holder.count.setText(city1[j]);
           // holder.messagetext.setText(message[j]);
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

                /*Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/


            }
        });

        holder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                /*Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/

video_list1[position]=1;
               /* startActivity(new Intent(InitCamera.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
               // holder.reply.setText("Replied");
               // holder.reply.setTextColor(Color.RED);
               flag=1;


                mPreferences = PreferenceManager.getDefaultSharedPreferences(c);

                mEditor = mPreferences.edit();


                mEditor.putString("videoflag","1");
                mEditor.putString("videosendid",id_count[j]);
                Log.v("idcount1:", id_count[j]);
                mEditor.commit();

                Intent i = new Intent(view.getContext(), MainActivity.class);
                //i.putExtra("stoken", token);
               // i.putExtra("smail",mail);
                //mEditor.putString("videoflag","1");
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();
            }
        });
        holder.messagetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Intent intent = new Intent(Page_Activity.this,SettingsActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);*/

                Log.v("videoid12:",id_count[position]);

                Intent i = new Intent(view.getContext(), Page_Activity8.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line
                /*i.putExtra("videoid",id_count[position]);
                i.putExtra("token", token);
                i.putExtra("mail",mail);*/


                mPreferences = PreferenceManager.getDefaultSharedPreferences(c);

                mEditor = mPreferences.edit();

                mEditor.putString("videoid",id_count[position]);
                mEditor.putString("token", token);
                mEditor.putString("mail",mail);

                mEditor.commit();
                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();


            }
        });
        holder.count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /*Intent i = new Intent(context, Invite.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                context.startActivity(i);*/


            }
        });
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);

               // Log.v("idcount1:", position);
                Log.v("firsttoken1", token);
                Log.v("firstmail1", mail);

                Intent i = new Intent(view.getContext(), video_play.class);
                i.putExtra("position", position);
                i.putExtra("token", token);
                i.putExtra("mail",mail);



                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                view.getContext().startActivity(i);
                ((Activity) view.getContext()).finish();
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


    }


    //TOTAL NUM
    @Override
    public int getItemCount() {

       /* Log.i(TAG, "itemcountadapter:" + itemcountadapter);
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