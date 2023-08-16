package com.example.weddingplanner.MealsData;

import java.io.Serializable;

public class Desserts implements Serializable  {

    private long mId;
    private String dessert;
    private int DessertImage;

    public Desserts( long id, String dessert , int DessertImage ){
        mId = id;
        this.dessert = dessert ;
        this.DessertImage = DessertImage ;

    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getDessert(){ return dessert ;}
    public  void setLunch(String dessert ){ this.dessert = dessert; }

    public int getDessertImage(){ return DessertImage; }
    public void setDessertImage(int dessertImage ){ this.DessertImage = DessertImage; }

}
