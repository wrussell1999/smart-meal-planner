package com.will_russell.smartmealplanner;


import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Ingredient{

    protected String ingredientName;
    protected ArrayList<String> Expiries = new ArrayList<String>();
    protected ArrayList<Integer> Quantities= new ArrayList<Integer>();
    protected ArrayList<Meal> possibleMeals= new ArrayList<Meal>();

    public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();



    public Ingredient(String name){
        ingredientName = name;

    }

    public String getingredientName() {
        return ingredientName;
    }

    public String getexpiryDate() {
        return Expiries.get(0);
    }
    public String getexpiryDate(int i) {
        return Expiries.get(i);
    }

    public int getQuantity() {
        return Quantities.get(0);
    }
    public int getQuantity(int i) {
        return Quantities.get(i);
    }

    public int getTotal(){
        int Total = 0;
        for (int i = 0; i<Quantities.size(); i++){
            Total += Quantities.get(i);
        }
        return Total;
    }

    public void addInventory(String expiry, int quantity){
        Expiries.add(expiry);
        Quantities.add(quantity);
    }

    public void expire(){
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        System.out.println(date);
        for (int i = 0; i<Expiries.size();i++){
            if (Expiries.get(i).equals(date)){
                Expiries.remove(i);
                Quantities.remove(i);
            }

        }

    }

    public void deplete(int used){
        while (used != 0){
            if (Quantities.get(0) >= used){
                Quantities.set(0,(Quantities.get(0)-used));
                used = 0;
            }
            else {
                used -= Quantities.get(0);
                Quantities.set(0,0);
            }

            if (Quantities.get(0) == 0){
                Expiries.remove(0);
                Quantities.remove(0);
            }
        }

    }

    public void addPossibleMeal(Meal possibleMeal){
        possibleMeals.add(possibleMeal);
    }

    public String getPossibleMeals(){
        String output = "";
        for (Meal meal : possibleMeals){
            output += meal.getMealName() + ", ";
        }
        return output;
    }

//To get info out of the ArrayList use form inventoryList[0][0].get(1)

}
