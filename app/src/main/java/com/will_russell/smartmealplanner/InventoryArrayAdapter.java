package com.will_russell.smartmealplanner;
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class InventoryArrayAdapter extends ArrayAdapter<Ingredient> {
    public InventoryArrayAdapter(Activity context ,ArrayList<Ingredient> ingredients) {
        super(context, 0, ingredients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row, parent, false);
            System.out.println(convertView);
        }
        System.out.println("convertView: " + convertView);
        // Get the data item for this position
        Ingredient ingredient = getItem(position);


        TextView main = (TextView)convertView.findViewById(R.id.titleTextID);
        TextView sub = (TextView)convertView.findViewById(R.id.subtitleTextID);

        String string_quantity = new Integer(ingredient.getQuantity()).toString();
        String new_name = ingredient.getingredientName() + ", " + string_quantity;
        System.out.println("STRING: " + new_name);
        main.setText(new_name);
        sub.setText(ingredient.getexpiryDate());
        // Return the completed view to render on screen
        return convertView;
    }

}

