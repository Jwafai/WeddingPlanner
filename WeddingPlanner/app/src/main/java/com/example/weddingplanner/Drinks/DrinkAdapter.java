package com.example.weddingplanner.Drinks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weddingplanner.MealsData.Drinks;
import com.example.weddingplanner.R;

import java.util.List;

public class DrinkAdapter extends BaseAdapter {


    private List<Drinks> mDrinkList;

    // Context
    private Context mContext;

    public DrinkAdapter(Context context, List<Drinks> foodList) {
        mContext = context;
        mDrinkList = foodList;
    }

    @Override
    public int getCount() {
        // Return the number of food items
        return mDrinkList.size();
    }

    @Override
    public Object getItem(int position) {
        // Return the food item at the specified position
        return mDrinkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Return the ID of the food item at the specified position
        return mDrinkList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the spinner item layout
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.drinksspinner, parent, false);
        }

        // Get the food item at the current position
        Drinks food = (Drinks) getItem(position);

        // Bind the food data to the views
        ImageView imageViewDrink = convertView.findViewById(R.id.imageViewDrinks);
        TextView textViewDrink = convertView.findViewById(R.id.textViewDrinks);
        imageViewDrink.setImageResource(food.getDrinkimage());
        textViewDrink.setText(food.getDrink());

        // Return the completed view
        return convertView;
    }


}
