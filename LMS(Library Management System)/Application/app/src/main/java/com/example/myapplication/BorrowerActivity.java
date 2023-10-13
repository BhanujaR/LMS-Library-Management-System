package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityBorrowerBinding;

import java.util.ArrayList;

public class BorrowerActivity extends AppCompatActivity {

    ActivityBorrowerBinding binding;
    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBorrowerBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
         customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);
        getDetails();
    }


    private void getDetails() {
        binding.getDetails.setOnClickListener(view -> {
            if (binding.name.getText().toString().equals("") && binding.address.getText().toString().equals("") && binding.phoneNumber.getText().toString().equals("")) {
                Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show();
            } else {
                String query = "INSERT INTO BORROWER (Name, Address, Phone) VALUES ('" + binding.name.getText().toString() + "', '" + binding.address.getText().toString() + "', '" + binding.phoneNumber.getText().toString() + "')";
                MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(query);
                Toast.makeText(this, "New Borrower added successfully", Toast.LENGTH_SHORT).show();
                String[] selectionArgs = {binding.name.getText().toString()};
                Cursor cursor = db.rawQuery("SELECT * FROM Borrower WHERE Name = ?", selectionArgs);

                if (cursor.moveToFirst()) {
                    do {
                        cursor.getString(0);
                        borrowerIds.add("Card Number: " + cursor.getString(0));
                        name.add("Name: " + cursor.getString(1));
                        lateFee.add("Address: " +cursor.getString(2) + " Phone Number:" + cursor.getString(3));
                    } while (cursor.moveToNext());
                }

                customAdapter.borrowerID = borrowerIds;
                customAdapter.name = name;
                customAdapter.lateFee = lateFee;
                customAdapter.notifyDataSetChanged();
            }

        });
    }
}