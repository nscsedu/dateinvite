package com.braincraft.social.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.braincraft.social.R;
import com.braincraft.social.activity.VideoRecorderRequestFragment.OnVideoRecorderListener;
//import com.crashlytics.android.Crashlytics;
import com.mikepenz.materialdrawer.DrawerBuilder;

import java.security.InvalidParameterException;

//import io.fabric.sdk.android.Fabric;

/**
 * Simple demo activity that request the required permissions if not granted, then starts the video
 * recording activity.
 */
public class MainActivity extends AppCompatActivity implements OnVideoRecorderListener {

    private ViewPager mViewPager;

    private VideoRecorderRequestFragment mRequestFragment;
    private VideoRecorderResultsFragment mResultsFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        new DrawerBuilder().withActivity(this).build();

        mRequestFragment = new VideoRecorderRequestFragment();
        mResultsFragment = new VideoRecorderResultsFragment();

        Toolbar toolbar = (Toolbar) findViewById(com.braincraft.social.R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onVideoRecorded(VideoFile videoFile) {
        mResultsFragment.addVideoFile(videoFile);
        mViewPager.setCurrentItem(1);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return mRequestFragment;
                case 1:
                    return mResultsFragment;
                default:
                    throw new InvalidParameterException("Invalid position");
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.recording);
                case 1:
                    return getString(R.string.results);
                default:
                    throw new InvalidParameterException("Invalid position");
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
