package com.example.jetpo.smartmealplanner;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AddIngredient extends AppCompatActivity {

    public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Test");
                EditText foodName_box = (EditText)findViewById(R.id.food_nameBox);
                EditText quantity_Box= (EditText)findViewById(R.id.quantityBox);
                EditText expiry_Box = (EditText)findViewById(R.id.expiryBox);
                ingredients.add(new Ingredient(foodName_box.getText().toString()));
                ingredients.get(ingredients.size()-1).addInventory(expiry_Box.getText().toString(),Integer.parseInt(quantity_Box.getText().toString()));
                finish();
            }
        });
    }

}
