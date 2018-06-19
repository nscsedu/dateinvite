package com.braincraft.social.dateinvite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;

/**
 * Created by umesh on 25-02-2017.
 */
public class WelcomeActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector gestureDetector;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private View logindemo,logindemo1;
    private PreferenceManager prefManager;
    int flag=0;
    int flagstate=0,flagpos=0;
    static  int k=0;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new PreferenceManager(this);
       /* if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }*/

        // Making notification bar1 transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
        logindemo = (View) findViewById(R.id.logindemo);
        logindemo1 = (View) findViewById(R.id.logindemo1);

       /* if (k == 1){
            Bundle bundle = getIntent().getExtras();
        flagstate = bundle.getInt("flagstate");
            Log.i(TAG, "flagstate1:" + flagstate);
    }*/
    k=1;
        Log.i(TAG, "flagstate:" + flagstate);
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.slide_screen1,
                R.layout.slide_screen2,
                R.layout.slide_screen3,
                R.layout.slide_screen4,
                R.layout.slide_screen5,
                R.layout.test1
               /* R.layout.registration_new*/

        };
       /* if(flagstate==1)
        { addBottomDots(4);

        }
else {*/
            // adding bottom dots
            addBottomDots(0);
       // }

        // making notification bar1 transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

       logindemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                startActivity(new Intent(WelcomeActivity.this, Login.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {

        if(motionEvent1.getY() - motionEvent2.getY() > 50){

            //Toast.makeText(RegistarActivity.this , " Swipe Up " , Toast.LENGTH_LONG).show();

            return true;
        }

        if(motionEvent2.getY() - motionEvent1.getY() > 50){

            // Toast.makeText(RegistarActivity.this , " Swipe Down " , Toast.LENGTH_LONG).show();

            return true;
        }

        if(motionEvent1.getX() - motionEvent2.getX() > 50){

            Toast.makeText(WelcomeActivity.this , " Swipe Left " , Toast.LENGTH_LONG).show();
            startActivity(new Intent(WelcomeActivity.this,RegistarActivity.class));


            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            if(flag==1)
            {
                startActivity(new Intent(WelcomeActivity.this,RegistarActivity.class));


                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            return true;
        }

        if(motionEvent2.getX() - motionEvent1.getX() > 50) {



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


    private void addBottomDots(int currentPage) {
        Log.i(TAG, "currentPage:" + currentPage);

      /*  if(flagstate==1)
        {
            currentPage=4;
        }*/
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        Log.i(TAG, "colorsActive:" + colorsActive);
        Log.i(TAG, "colorsInactive:" + colorsInactive);
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
       // startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
        startActivity(new Intent(WelcomeActivity.this, RegistarActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            Log.i(TAG, "position:" + position);
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                logindemo1.setVisibility(View.GONE);
               /* btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);*/
               /* startActivity(new Intent(WelcomeActivity.this, RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                startActivity(new Intent(WelcomeActivity.this, MessageBeforeReg.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();

        flag=1;





            }
            else  if (position == 0 ) {

                logindemo1.setVisibility(View.VISIBLE);

            }

          else  if (position == layouts.length ) {
                flag=0;
                logindemo1.setVisibility(View.GONE);
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);

                startActivity(new Intent(WelcomeActivity.this, RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }

            else {logindemo1.setVisibility(View.GONE);
                flag=0;
                // still pages are left
              //  btnNext.setText(getString(R.string.next));
                btnNext.setText("");
               // btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * Making notification bar1 transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          /* if(flagstate==1&& flagpos==0)
            {
                position=4;
                flagpos=1;
            }*/

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
