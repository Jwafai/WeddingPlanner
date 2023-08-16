package com.example.weddingplanner.MealsData;

import java.io.Serializable;
import java.util.function.LongUnaryOperator;

public class Meals implements Serializable {
    private long mId;
    private String lunch;
    private int lunchimage ;

    public Meals( long id, String lunche , int lunchimagee ){
        mId = id;
        lunch = lunche ;
        lunchimage = lunchimagee ;

    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getLunch(){ return lunch ;}
    public  void setLunch(String lunch ){ this.lunch = lunch; }

    public int getLunchimage(){ return lunchimage; }
    public void setLunchimage(int LunchImage ){ this.lunchimage = lunchimage; }

}
