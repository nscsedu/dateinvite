package com.braincraft.social.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.braincraft.social.R;


/**
 * Created by ADMIN on 16/6/2018.
 */

public class FragmentVideo extends Fragment{
    View view;
    // Button secondButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentvideo, container, false);

        return view;
    }
}

