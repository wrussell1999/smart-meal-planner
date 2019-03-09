package com.will_russell.smartmealplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ShoppingFragment extends Fragment{

    public static ShoppingFragment newInstance(){

        ShoppingFragment fragment = new ShoppingFragment();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_fragment, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Intent in = new Intent(activity, AddItem.class);
                activity.startActivityForResult(in, 1);
            }
        });

        return view;
    }
}