package com.will_russell.smartmealplanner;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InventoryFragment extends Fragment{

    public static InventoryFragment newInstance(){

        InventoryFragment fragment = new InventoryFragment();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inventory_fragment, container, false);

        InventoryArrayAdapter adapter = new InventoryArrayAdapter(getActivity(), Ingredient.ingredients);
        ListView listview = (ListView) view.findViewById(R.id.inventory_listview);
        listview.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Intent in = new Intent(activity, AddIngredient.class);
                activity.startActivityForResult(in, 1);

            }
        });

        return view;
    }
}
