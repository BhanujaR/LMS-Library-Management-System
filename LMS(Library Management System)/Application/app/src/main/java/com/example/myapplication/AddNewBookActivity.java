package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityAddNewBookBinding;

import java.util.ArrayList;

public class AddNewBookActivity extends AppCompatActivity {


    ActivityAddNewBookBinding binding;
    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNewBookBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, getPublisherName(db, "BOOK"));
        //Set the adapter
        binding.publisherSpinner.setAdapter(titleAdapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);
        binding.addBook.setOnClickListener(view -> {
            if (binding.bookTitle.getText().toString().equals("") && binding.authorName.getText().toString().equals("")) {
                Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show();
            } else {

                // Insert the new book into the BOOK table
                String insertBookQuery = "INSERT INTO BOOK (Title, Publisher_Name) " +
                        "VALUES ("+"'"+binding.bookTitle.getText().toString()+"'"+ ", " +
                        "(SELECT Publisher_Name FROM PUBLISHER WHERE Publisher_Name ="+ "'"+ binding.publisherSpinner.getSelectedItem().toString()+"'"+"))";
                db.execSQL(insertBookQuery);

// Get the Book_Id of the newly added book
                String getBookIdQuery = "SELECT last_insert_rowid()";
                Cursor cursor = db.rawQuery(getBookIdQuery, null);
                int newBookId = 0;
                if (cursor.moveToFirst()) {
                    newBookId = cursor.getInt(0);
                }
                cursor.close();

// Link the new book with its author(s) in the BOOK_AUTHORS table
                String insertBookAuthorQuery = "INSERT INTO BOOK_AUTHORS (Book_Id, Author_Name) " +
                        "VALUES (" + newBookId + ", " + "'" + binding.authorName.getText().toString() + "'" + ")";
                db.execSQL(insertBookAuthorQuery);

// Insert 5 copies of the new book into each branch in the BOOK_COPIES table
                String insertBookCopiesQuery = "INSERT INTO BOOK_COPIES (Book_Id, Branch_Id, No_Of_Copies) " +
                        "SELECT " + newBookId + ", Branch_Id, 5 AS No_Of_Copies " +
                        "FROM LIBRARY_BRANCH";
               db.execSQL(insertBookCopiesQuery);

                String resultQuery = "SELECT BOOK.Title, BOOK_COPIES.No_Of_Copies, LIBRARY_BRANCH.Branch_Name " +
                        "FROM BOOK, BOOK_COPIES, LIBRARY_BRANCH " +
                        "WHERE BOOK.Book_Id = BOOK_COPIES.Book_Id " +
                        "AND LIBRARY_BRANCH.Branch_Id = BOOK_COPIES.Branch_Id " +
                        "AND BOOK.Book_Id = " + newBookId;
                Cursor resultCursor = db.rawQuery(resultQuery, null);

                if (resultCursor.moveToFirst()) {
                    do {
                        borrowerIds.add("Title: " + resultCursor.getString(0));
                        name.add("No.Of Copies: " + resultCursor.getString(1));
                        lateFee.add("Branch Name:  " + resultCursor.getString(2));
                    } while (resultCursor.moveToNext());
                }

                customAdapter.borrowerID = borrowerIds;
                customAdapter.name = name;
                customAdapter.lateFee = lateFee;
                customAdapter.notifyDataSetChanged();

            }
        });
    }

    public ArrayList<String> getPublisherName(SQLiteDatabase db, String tableName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("SELECT Publisher_Name FROM " + tableName, null);
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }
}