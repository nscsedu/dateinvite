package com.braincraft.social.activity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import com.braincraft.social.R;

import static com.braincraft.social.activity.Invite.left;
import static com.braincraft.social.activity.Invite.right;
import static com.braincraft.social.activity.Invite.vd;
import static com.braincraft.social.activity.Invite1.left1;
import static com.braincraft.social.activity.Invite1.right1;
import static com.braincraft.social.activity.Invite4.left4;
import static com.braincraft.social.activity.Invite4.right4;

/**
 * Created by ADMIN on 13/5/2018.
 */

public class ViewPagerAdapter1 extends PagerAdapter {
    private boolean isImage = false;
    private String reviewImageLink;
    private MediaController mc;
    int flagvideo=0;
    int vidcount=0;
    public static int newpos;
    public static TextView select1;
    int currentpage;

    public static int  posinvite =0;
    private static final String TAG = "MyActivity";
    private Context context;
    private LayoutInflater layoutInflater;
    //private Integer [] images = {R.drawable.small_card_dinner_en,R.drawable.card_coffee_en,R.drawable.card_drink_en,R.drawable.small_card_dinner_en};
    private Integer [] images = {R.raw.card_coffee_en,R.raw.card_drink_en,R.raw.card_dinner_en,R.raw.test};


    public ViewPagerAdapter1(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        select1=(TextView) view.findViewById(R.id.select1);
        imageView.setImageResource(images[position]);

        select1.setVisibility(View.GONE);



      /*  select1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE

                if(newpos==1)
                {Log.i(TAG, "newpos2:" +  newpos);

                    Intent i = new Intent(view.getContext(), ind_drink.class);

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                    view.getContext().startActivity(i);

                }
                if(newpos==2)
                {Log.i(TAG, "newpos3:" +  newpos);

                    Intent i = new Intent(view.getContext(), ind_dinner.class);

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                    view.getContext().startActivity(i);

                }

            }
        });*/



        vidcount++;
        if(vidcount==3)
        {

        }
        posinvite=position;
        Log.i(TAG, "images[position]:" +  images[position]);
        Log.i(TAG, "pos123:" +  position);
        Log.i(TAG, "posinvite2:" +  posinvite);

        Log.i(TAG, "vidcount:" +  vidcount);



       /* if( imageView.getDrawable() !=null)
        {

            vd.setVisibility(View.GONE);

        }
        else
        {
            vd.setVisibility(View.VISIBLE);
        }*/

       /* if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            if (image.getDrawable().getConstantState().equals(image.getContext().getDrawable(R.drawable.shadow_round_white).getConstantState())){

                image.setVisibility(View.GONE);
            }
            else{
                image.setVisibility(View.VISIBLE);
            }

        }
        else {
            if (image.getDrawable().getConstantState().equals(getResources().getDrawable(R.raw.test).getConstantState())){
                image.setVisibility(View.GONE);
            }

            else{
                image.setVisibility(View.VISIBLE);
            }
        }*/


       /* VideoView vd = (VideoView) view.findViewById(R.id.VideoView);

        // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");

        Uri uri  = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/"
                + R.raw.test);

        mc = new MediaController(view.getContext());
        vd.setMediaController(mc);

        vd.setVideoURI(uri);*/



        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);



        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                newpos=position;
                Log.i(TAG, "newpos1:" +  newpos);






                if(position == 3){  // if you want the second page, for example
                    //Your code here
                    vd.setVisibility(View.VISIBLE);
                    left1.setVisibility(View.GONE);
                    right1.setVisibility(View.GONE);

                   /* left1.setVisibility(View.GONE);
                    right1.setVisibility(View.GONE);

                    left2.setVisibility(View.GONE);
                    right2.setVisibility(View.GONE);

                    left3.setVisibility(View.GONE);
                    right3.setVisibility(View.GONE);

                    left4.setVisibility(View.GONE);
                    right4.setVisibility(View.GONE);*/

                    // sendinvitation.setVisibility(View.GONE);
                    //like_off.setVisibility(View.GONE);
                    // right.setVisibility(View.VISIBLE);
                   /* right1.setVisibility(View.VISIBLE);
                    right2.setVisibility(View.VISIBLE);
                    right3.setVisibility(View.VISIBLE);
                    right4.setVisibility(View.VISIBLE);*/
                }
                else
                {    //sendinvitation.setVisibility(View.VISIBLE);
                    //like_off.setVisibility(View.VISIBLE);
                    vd.setVisibility(View.GONE);
                    if(position==0)
                    {
                        left1.setVisibility(View.GONE);
                        right1.setVisibility(View.VISIBLE);

                        /*left1.setVisibility(View.GONE);
                        right1.setVisibility(View.VISIBLE);

                        left2.setVisibility(View.GONE);
                        right2.setVisibility(View.VISIBLE);

                        left3.setVisibility(View.GONE);
                        right3.setVisibility(View.VISIBLE);*/


                        // left.setVisibility(View.VISIBLE);
                       /* left1.setVisibility(View.VISIBLE);
                        left2.setVisibility(View.VISIBLE);
                        left3.setVisibility(View.VISIBLE);
                        left4.setVisibility(View.VISIBLE);*/



                        /*startActivity(new Intent(Invite.this,IndividualInvitation.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                      /*  Intent i = new Intent(view.getContext(), IndividualInvitation.class);

                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //add this line

                        view.getContext().startActivity(i);*/

                    }
                    if(position==2)
                    {
                        right1.setVisibility(View.GONE);
                        left1.setVisibility(View.VISIBLE);

                       /* right1.setVisibility(View.GONE);
                        left1.setVisibility(View.VISIBLE);

                        right2.setVisibility(View.GONE);
                        left2.setVisibility(View.VISIBLE);

                        right3.setVisibility(View.GONE);
                        left3.setVisibility(View.VISIBLE);

                        right4.setVisibility(View.GONE);
                        left4.setVisibility(View.VISIBLE);*/

                    }
                    else

                    { //left.setVisibility(View.VISIBLE);
                       /* left1.setVisibility(View.VISIBLE);
                        left2.setVisibility(View.VISIBLE);
                        left3.setVisibility(View.VISIBLE);
                        left4.setVisibility(View.VISIBLE);*/

                        // right.setVisibility(View.VISIBLE);
                       /* right1.setVisibility(View.VISIBLE);
                        right2.setVisibility(View.VISIBLE);
                        right3.setVisibility(View.VISIBLE);
                        right4.setVisibility(View.VISIBLE);*/
                        left1.setVisibility(View.VISIBLE);
                        right1.setVisibility(View.VISIBLE);


                        /*left2.setVisibility(View.VISIBLE);
                        right2.setVisibility(View.VISIBLE);

                        left1.setVisibility(View.VISIBLE);
                        right1.setVisibility(View.VISIBLE);

                        left3.setVisibility(View.VISIBLE);
                        right3.setVisibility(View.VISIBLE);

                        left4.setVisibility(View.VISIBLE);
                        right4.setVisibility(View.VISIBLE);*/
                    }


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        Log.i(TAG, "posinvite1:" + position);
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}