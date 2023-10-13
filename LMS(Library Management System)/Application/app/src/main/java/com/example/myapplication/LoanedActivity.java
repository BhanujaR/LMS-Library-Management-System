package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityLoanedBinding;

import java.util.ArrayList;

public class LoanedActivity extends AppCompatActivity {

    ActivityLoanedBinding binding;

    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoanedBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, getBookTitle(db, "BOOK"));
        //Set the adapter
        binding.bookSpinner.setAdapter(titleAdapter);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);

        binding.getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrowerIds = new ArrayList<>();
                name = new ArrayList<>();
                lateFee = new ArrayList<>();

             /*   String query = "SELECT Title, Branch_Name, No_Of_Copies " +
                        "FROM Book " +
                        "JOIN Book_Copies ON Book.Book_Id = Book_Copies.Book_Id " +
                        "JOIN Library_Branch ON Book_Copies.Branch_Id = Library_Branch.Branch_Id " +
                        "WHERE Book.Book_Id = ? AND Library_Branch.Branch_Id = ?;";
                String[] selectionArgs = {String.valueOf(bookId), String.valueOf(branchId)};
                Cursor cursor = db.rawQuery(query, selectionArgs); */


                String query = "SELECT BOOK.Title, LIBRARY_BRANCH.Branch_Name,COUNT(BOOK_LOANS.Book_Id) " +
                        "FROM BOOK, BOOK_LOANS, LIBRARY_BRANCH " +
                        "WHERE BOOK_LOANS.Book_Id = BOOK.Book_Id " +
                        "AND LIBRARY_BRANCH.Branch_Id = BOOK_LOANS.Branch_Id " +
                        "AND BOOK.Title = "+ "'" + binding.bookSpinner.getSelectedItem()+"' GROUP BY BOOK_LOANS.Branch_Id";
                //String[] selectionArgs = {String.valueOf(binding.bookSpinner.getSelectedItem())};
                Cursor cursor = db.rawQuery(query,null);

                if(cursor.moveToFirst()){
                    do {
                        cursor.getString(0);

                        borrowerIds.add("Book Title: " + cursor.getString(0));
                        name.add("Branch Name: " + cursor.getString(1));
                        lateFee.add("No of books loaned: " + cursor.getString(2));
                    }while (cursor.moveToNext());
                }

                customAdapter.borrowerID = borrowerIds;
                customAdapter.name = name;
                customAdapter.lateFee = lateFee;
                customAdapter.notifyDataSetChanged();
            }
        });
    }

    public ArrayList<String> getBookTitle(SQLiteDatabase db, String tableName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("SELECT Title FROM " + tableName, null);
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }
}