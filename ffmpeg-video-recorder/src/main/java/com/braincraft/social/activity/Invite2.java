package com.braincraft.social.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.braincraft.social.R;

import org.w3c.dom.Text;

import static com.braincraft.social.activity.ViewPagerAdapter.newpos;
import static com.braincraft.social.activity.ViewPagerAdapter.posinvite;

/**
 * Created by User on 4/20/2018.
 */

public class Invite2 extends AppCompatActivity {

    private static final String TAG = "PRANJAL";
    private boolean isImage = false;
    private String reviewImageLink;
    private MediaController mc;
    public int likeflag=0;
    private int currentpage;

    public static VideoView vd;

    public int message=2;


    public static TextView sendinvitation,like_off;
    public static TextView select,left2,right2;
    private Button submit, btnlogin_submit;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indprofile1);


        select=(TextView) findViewById(R.id.select);
        vd = (VideoView) findViewById(R.id.VideoView);


        left2=(TextView) findViewById(R.id.left);
        right2=(TextView) findViewById(R.id.right);
       /* left2.setVisibility(View.GONE);
        right2.setVisibility(View.GONE);*/
        // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");
        left2.setVisibility(View.GONE);
        Uri uri  = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test);

        mc = new MediaController(this);
        vd.setMediaController(mc);

        vd.setVideoURI(uri);

        vd.setVisibility(View.GONE);


        // vd.start();

       /* ImageView imageview_mini = (ImageView)findViewById(R.id.thumbnail_mini);
        Bitmap bmThumbnail;
        bmThumbnail = ThumbnailUtils.createVideoThumbnail("android.resource://" + getPackageName() + "/"
                + R.raw.test, MediaStore.Images.Thumbnails.MINI_KIND);
        imageview_mini.setImageBitmap(bmThumbnail);*/

       /* imageView.setOnTouchListener(new OnSwipeTouchListener(MyActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(MyActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MyActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(MyActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(MyActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });*/


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sendinvitation = (TextView) findViewById(R.id.sendinvitation);

        like_off = (TextView) findViewById(R.id.like_off);


        ViewPagerAdapter2 viewPagerAdapter = new ViewPagerAdapter2(this);

        viewPager.setAdapter(viewPagerAdapter);




        currentpage = viewPager.getCurrentItem();

        Log.i(TAG, "currentpage:" +  currentpage);

        right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
               /* overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

            }
        });
        left2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
               /* overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Invite2.this,Liked.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(R.anim.your_left_to_right, R.anim.your_right_to_left);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);
        sendinvitation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
              /*  startActivity(new Intent(Invite2.this,Interaction.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
*/


                Intent intent = new Intent(Invite2.this, Interaction.class);
                intent.putExtra("message", message);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        Log.i(TAG, "likeflagoff1:" + likeflag);
        like_off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                Log.i(TAG, "likeflagoff1:" + likeflag);
                like_off.setBackgroundResource(R.drawable.like_on);
               /* if(likeflag==0) {
                    Log.i(TAG, "likeflagoff1:" + likeflag);
                    like_off.setBackgroundResource(R.drawable.like_on);
                    likeflag = 1;
                }*/
                Log.i(TAG, "likeflagoff2:" + likeflag);

               /* Log.i(TAG, "likeflagoff1:" + likeflag);
                if(likeflag==1) {
                    Log.i(TAG, "likeflagoff2:" + likeflag);
                    like_off.setBackgroundResource(R.drawable.like_off);
                    likeflag = 0;
                }*/

            }
        });
        // Log.i(TAG, "likeflagoff:" + likeflag);
       /*if(likeflag==1)
       {
           like_off.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view){
                   //DO YOUR CODE
                   like_off.setBackgroundResource(R.drawable.like_off);
                   likeflag=0;
                   Log.i(TAG, "likeflagon1:" + likeflag);

               }
           });



       }*/
        Log.i(TAG, "likeflagon:" + likeflag);
        Log.i(TAG, "posinvite123:" + posinvite);

        Log.i(TAG, "newpos123:" +  newpos);
        select.setVisibility(View.GONE);
       /* select.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
               if(newpos==0)
               {startActivity(new Intent(Invite.this,IndividualInvitation.class));
                   overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

               }
                if(newpos==1)
                {
                    startActivity(new Intent(Invite.this,ind_drink.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if(newpos==2)
                {
                    startActivity(new Intent(Invite.this,ind_dinner.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }


            }
        });*/

   /*     if(posinvite==0)
        {
            vd.setVisibility(View.VISIBLE);
        }
        else
        {
            vd.setVisibility(View.GONE);
        }
*/



        //  sendinvitation=(Button) findViewById(R.id.sendinvitation);


      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("androidtest");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Invite.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });*/

       /* sendinvitation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(Invite.this,Interaction.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/



       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Privacy.this,HomeActivity.class));
            }
        });*/



    }
}
