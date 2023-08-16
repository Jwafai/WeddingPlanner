package com.example.weddingplanner.Lunch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weddingplanner.MealsData.Meals;
import com.example.weddingplanner.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private List<Meals> mFoodList;

    // Context
    private Context mContext;

    public FoodAdapter(Context context, List<Meals> foodList) {
        mContext = context;
        mFoodList = foodList;
    }

    @Override
    public int getCount() {
        // Return the number of food items
        return mFoodList.size();
    }

    @Override
    public Object getItem(int position) {
        // Return the food item at the specified position
        return mFoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Return the ID of the food item at the specified position
        return mFoodList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the spinner item layout
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lunchspinner, parent, false);
        }

        // Get the food item at the current position
        Meals food = (Meals) getItem(position);

        // Bind the food data to the views
        ImageView imageViewFood = convertView.findViewById(R.id.imageViewFood);
        TextView textViewFood = convertView.findViewById(R.id.textViewFood);
        imageViewFood.setImageResource(food.getLunchimage());
        textViewFood.setText(food.getLunch());

        // Return the completed view
        return convertView;
    }
}
