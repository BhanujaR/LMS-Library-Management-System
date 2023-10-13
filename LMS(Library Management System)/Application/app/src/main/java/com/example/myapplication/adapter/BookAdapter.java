package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter {
    public ArrayList<String>borrowerID;
    public ArrayList<String> name;
    public ArrayList<String> lateFee;
    Context context;

    public BookAdapter(Context context, ArrayList<String> borrowerID, ArrayList<String> name, ArrayList<String> lateFee) {
        this.context = context;
        this.borrowerID = borrowerID;
        this.name = name;
        this.lateFee = lateFee;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.late_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView b = holder.itemView.findViewById(R.id.borrower_id);
        TextView n =  holder.itemView.findViewById(R.id.name);
        TextView l = holder.itemView.findViewById(R.id.late_fee);
        b.setText(borrowerID.get(position));
        n.setText(name.get(position));
        l.setText(lateFee.get(position));
    }


    @Override
    public int getItemCount() {
        return borrowerID.size();
    }

    public class MyViewHolder extends   RecyclerView.ViewHolder {
        TextView borrowerID;// init the item view's
        TextView name;// init the item view's
        TextView lateFee;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            borrowerID = (TextView) itemView.findViewById(R.id.borrower_id);
            name = (TextView) itemView.findViewById(R.id.name);
            lateFee = (TextView) itemView.findViewById(R.id.late_fee);
        }
    }
}