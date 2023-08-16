package com.example.weddingplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<UserList> list;


    public MyAdapter(Context context, ArrayList<UserList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardviewlist,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserList user = list.get(position);
        holder.FirstName.setText(user.getName());
        holder.PhoneNum.setText(user.getPhonenum());
        holder.GuestName.setText(user.getGuestname());
        holder.Food.setText(user.getFood());
        holder.Drinks.setText(user.getDrinks());
        holder.Dessert.setText(user.getDessert());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView FirstName, PhoneNum , GuestName , Food , Drinks , Dessert ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FirstName = (TextView) itemView.findViewById(R.id.tvfirstName);
            PhoneNum = (TextView) itemView.findViewById(R.id.tvphonenum);
            GuestName = (TextView) itemView.findViewById(R.id.tvguestname);
            Food = (TextView) itemView.findViewById(R.id.tvfood);
            Drinks = (TextView) itemView.findViewById(R.id.tvdrinks);
            Dessert = (TextView) itemView.findViewById(R.id.tvdessert);

        }
    }



}
