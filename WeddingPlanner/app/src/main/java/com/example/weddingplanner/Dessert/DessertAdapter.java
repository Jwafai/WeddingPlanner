package com.example.weddingplanner.Dessert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weddingplanner.MealsData.Desserts;
import com.example.weddingplanner.MealsData.Drinks;
import com.example.weddingplanner.R;

import java.util.List;

public class DessertAdapter extends BaseAdapter {

    private List<Desserts> mDrinkList;

    // Context
    private Context mContext;

    public DessertAdapter(Context context, List<Desserts> foodList) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.dessertspinner, parent, false);
        }

        // Get the food item at the current position
        Desserts food = (Desserts) getItem(position);

        // Bind the food data to the views
        ImageView imageViewDessert = convertView.findViewById(R.id.imageViewDesserts);
        TextView textViewDessert= convertView.findViewById(R.id.textViewDesserts);
        imageViewDessert.setImageResource(food.getDessertImage());
        textViewDessert.setText(food.getDessert());

        // Return the completed view
        return convertView;
    }

}
