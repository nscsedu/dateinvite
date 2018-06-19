package com.braincraft.social.dateinvite.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.braincraft.social.dateinvite.R;


/**
 * Created by ADMIN on 7/6/2018.
 */

public class FragmentFourth extends Fragment {
View view;
    public FragmentFourth() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.slide_screen4, container, false);


        View  viewbutton2 = (View) getActivity().findViewById(R.id.logindemo1);
        viewbutton2.setVisibility(View.INVISIBLE);
// get the reference of Button
        // secondButton = (Button) view.findViewById(R.id.secondButton);
// perform setOnClickListener on second Button
       /* secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                Toast.makeText(getActivity(), "Second Fragment", Toast.LENGTH_LONG).show();
            }
        });*/
        return view;
    }

}