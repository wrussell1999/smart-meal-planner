package com.will_russell.smartmealplanner;
import java.util.ArrayList;


public class Meal{

    protected String mealName;
    protected ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    protected ArrayList<Integer> amountNeeded = new ArrayList<Integer>();

    public Meal(String name){
        mealName = name;
    }

    public String getMealName(){
        return mealName;
    }

    public void addIngredients(Ingredient ingredient, int quantity){
        ingredient.addPossibleMeal(this);
        ingredients.add(ingredient);
        amountNeeded.add(quantity);

    }

    public boolean checkIngredients(){
        for (int i = 0; i < ingredients.size(); i++){
            if (ingredients.get(i).getTotal() < amountNeeded.get(i)){
                return false;
            }
        }
        return true;
    }

    public void makeMeal(){
        if (checkIngredients()){
            for (int i = 0; i < ingredients.size(); i++){
                ingredients.get(i).deplete(amountNeeded.get(i));

            }
        }

    }

}
