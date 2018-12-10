package com.example.jetpo.smartmealplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShoppingFragment extends Fragment{

    public static ShoppingFragment newInstance(){

        ShoppingFragment fragment = new ShoppingFragment();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shopping_fragment, container, false);
    }

}