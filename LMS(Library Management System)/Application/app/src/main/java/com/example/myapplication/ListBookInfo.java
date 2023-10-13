package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityListBookInfoBinding;

import java.util.ArrayList;

public class ListBookInfo extends AppCompatActivity {
    ActivityListBookInfoBinding binding;

    ArrayList<String> bookIds = new ArrayList<>();
    ArrayList<String> BookName = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBookInfoBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, bookIds, BookName, lateFee);
        recyclerView.setAdapter(customAdapter);
        binding.getLateBalanceAllCustomers.setOnClickListener(view -> {

            String bookId = binding.bookIdInput.getText().toString();
            String bookTitle = binding.bookTitle.getText().toString();

            String createViewSql ="SELECT * FROM books_view " +
                    "WHERE (book_id LIKE '%" + bookId + "%' OR '" + bookId + "' IS NULL) " +
                    "AND (book_title LIKE '%" + bookTitle + "%' OR '" + bookTitle + "' IS NULL);";





            Cursor cursor = db.rawQuery(createViewSql, null);
            ArrayList<String> borrowerIds = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> lateFee = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    borrowerIds.add("Book ID: " + cursor.getString(0));
                    name.add("Title: " + cursor.getString(1));
                    lateFee.add("Late Fee: " + cursor.getString(2));
                } while (cursor.moveToNext());
            }
            cursor.close();
            customAdapter.borrowerID = borrowerIds;
            customAdapter.name = name;
            customAdapter.lateFee = lateFee;
            customAdapter.notifyDataSetChanged();
        });
        //get_late_balance();

    }
}