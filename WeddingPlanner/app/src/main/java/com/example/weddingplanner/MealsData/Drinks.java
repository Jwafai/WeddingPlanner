package com.example.weddingplanner.MealsData;

import java.io.Serializable;

public class Drinks implements Serializable {


    private long mId;
    private String Drink;
    private int Drinkimage ;

    public Drinks( long id, String Drink , int Drinkimagee ){
        mId = id;
        this.Drink = Drink ;
        this.Drinkimage = Drinkimagee ;

    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getDrink(){ return Drink ;}
    public  void setDrink(String Drink ){ this.Drink = Drink; }

    public int getDrinkimage(){ return Drinkimage; }
    public void setDrinkimage(int LunchImage ){ this.Drinkimage = Drinkimage; }
}
