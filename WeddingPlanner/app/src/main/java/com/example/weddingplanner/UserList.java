package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class UserList  {

    String Name , Phonenum , Guestname, food , drinks , dessert ;

    public UserList()
    {
        Log.d("constructor2","ok");
        this.Name =  getName() ;
        this.Phonenum =  getPhonenum() ;
        this.Guestname =  "" ;
        this.food =  "" ;
        this.drinks =  "" ;
        this.dessert =  "" ;
    }

    public UserList ( String Name , String Phonenum , String Guestname , String food , String drinks , String dessert  )
    {
        Log.d("constructor","ok");
        this.Name =  Name ;
        this.Phonenum =  Phonenum ;
        this.Guestname =  Guestname ;
        this.food =  food ;
        this.drinks =  drinks ;
        this.dessert =  dessert ;

    }

    public String getName() {
        return Name;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public String getGuestname() {
        return Guestname;
    }

    public String getFood() {
        return food;
    }

    public String getDrinks() {
        return drinks;
    }

    public String getDessert() {
        return dessert;
    }
}
