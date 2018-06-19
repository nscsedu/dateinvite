package com.braincraft.social.dateinvite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.*;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.braincraft.social.dateinvite.fragments.FragmentFive;
import com.braincraft.social.dateinvite.fragments.FragmentFourth;
import com.braincraft.social.dateinvite.fragments.FragmentOne;
import com.braincraft.social.dateinvite.fragments.FragmentRegister;
import com.braincraft.social.dateinvite.fragments.FragmentThree;
import com.braincraft.social.dateinvite.fragments.FragmentTwo;
import com.braincraft.social.dateinvite.fragments.Fragmentsix;

import java.util.ArrayList;
import java.util.List;

import static com.braincraft.social.activity.chatmessage.name11;

/**
 * Created by ADMIN on 8/6/2018.
 */

public class ViewTest extends AppCompatActivity implements GestureDetector.OnGestureListener{
    public static SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;
    private View logindemo,logindemo1;
    public  static String  pager_flag="0";
    private ViewPager viewPager;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewtest);
        mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        if (pager_flag.toLowerCase().contains("0"))

        {   mEditor = mPreferences.edit();


        mEditor.putString("pager_flag", pager_flag);

        mEditor.commit();
        }

       else
           {
/*
            mEditor = mPreferences.edit();

            mEditor.putString("first", "United States");

            mEditor.commit();
            */



               SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
               SharedPreferences.Editor editor = mPreferences.edit();
               String first = mPreferences.getString("pager_flag", "");
               Log.v("first123:",first);
        }




        logindemo = (View) findViewById(R.id.logindemo);
        logindemo1 = (View) findViewById(R.id.logindemo1);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        com.robohorse.pagerbullet.PagerBullet viewPager = (com.robohorse.pagerbullet.PagerBullet) findViewById(R.id.pager);
       // ViewPager viewPager = (android.support.v4.view.ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "FRAG1");
        adapter.addFragment(new FragmentTwo(), "FRAG2");
        adapter.addFragment(new FragmentThree(), "FRAG3");
        adapter.addFragment(new FragmentFourth(), "FRAG2");
        adapter.addFragment(new FragmentFive(), "FRAG3");
        adapter.addFragment(new Fragmentsix(), "FRAG2");
        //adapter.addFragment(new FragmentRegister(), "FRAG3");
        viewPager.setAdapter(adapter);

       // TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
       // tabLayout.setupWithViewPager(viewPager);
        logindemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                startActivity(new Intent(ViewTest.this, Login.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();

            }
        });

    }



    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {


            // changing the next button text 'NEXT' / 'GOT IT'

            if (position == 0 ) {

                logindemo1.setVisibility(View.VISIBLE);

            }

            else   {

                logindemo1.setVisibility(View.GONE);
            }


        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {

        if(motionEvent1.getY() - motionEvent2.getY() > 50){

            //Toast.makeText(RegistarActivity.this , " Swipe Up " , Toast.LENGTH_LONG).show();
            logindemo1.setVisibility(View.GONE);
            return true;
        }

        if(motionEvent2.getY() - motionEvent1.getY() > 50){

            // Toast.makeText(RegistarActivity.this , " Swipe Down " , Toast.LENGTH_LONG).show();
            logindemo1.setVisibility(View.GONE);
            return true;
        }

        if(motionEvent1.getX() - motionEvent2.getX() > 50){

            logindemo1.setVisibility(View.GONE);

            return true;
        }

        if(motionEvent2.getX() - motionEvent1.getX() > 50) {

            logindemo1.setVisibility(View.GONE);

            // Toast.makeText(RegistarActivity.this, " Swipe Right ", Toast.LENGTH_LONG).show();

            return true;
        }
        else {

            return true ;
        }
    }
    @Override
    public void onLongPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // TODO Auto-generated method stub

        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {

        // TODO Auto-generated method stub

        return false;
    }

}
