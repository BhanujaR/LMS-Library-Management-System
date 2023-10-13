package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityCheckOutBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    ActivityCheckOutBinding binding;

    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckOutBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, getTitle(db, "BOOK"));
        //Set the adapter
        binding.titleSpinner.setAdapter(titleAdapter);
        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, getBranch(db, "LIBRARY_BRANCH"));
        //Set the adapter
        binding.branchSpinner.setAdapter(branchAdapter);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);

        binding.btnCheckOut.setOnClickListener(view -> {
            if(binding.cardNumberEt.getText().length() >0){
                int bookId = Integer.parseInt(getBookID(db, binding.titleSpinner.getSelectedItem().toString()).get(0));
                int branchId = Integer.parseInt(getBranchId(db, binding.branchSpinner.getSelectedItem().toString())
                        .get(0));

// Create a Date object with the date you want to format
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date = localDate.format(formatter);
                String dueDate = LocalDate.now().plusDays(7).format(formatter);
                int cardNo = Integer.parseInt(binding.cardNumberEt.getText().toString());
                ContentValues values = new ContentValues();
                values.put("Book_Id", bookId);
                values.put("Branch_Id", branchId);
                values.put("Card_No", cardNo);
                values.put("Date_Out", date);
                values.put("Due_Date", dueDate);
                // Inserting Row
                db.insert("BOOK_LOANS", null, values);

                String sql = "UPDATE BOOK_COPIES SET No_Of_Copies = No_Of_Copies - 1 WHERE Book_Id = ? AND Branch_Id = ?";
                Object[] bindArgs = { bookId, branchId };
                db.execSQL(sql, bindArgs);

                String query = "SELECT Title, Branch_Name, No_Of_Copies " +
                        "FROM Book " +
                        "JOIN Book_Copies ON Book.Book_Id = Book_Copies.Book_Id " +
                        "JOIN Library_Branch ON Book_Copies.Branch_Id = Library_Branch.Branch_Id ";
                String[] selectionArgs = {String.valueOf(bookId), String.valueOf(branchId)};
                Cursor cursor = db.rawQuery(query, null);
                if(cursor.moveToFirst()){
                    do {
                        cursor.getString(0);
                        borrowerIds.add("Title: " + cursor.getString(0));
                        name.add("Branch Name: " + cursor.getString(1));
                        lateFee.add("No.Of Copies: " + cursor.getString(2));
                       // binding.output.setText("Results :" + cursor.getString(0)+" " + cursor.getString(1)+" "+cursor.getString(2));
                    }while (cursor.moveToNext());
                }

                customAdapter.borrowerID = borrowerIds;
                customAdapter.name = name;
                customAdapter.lateFee = lateFee;
                customAdapter.notifyDataSetChanged();

            }


        });
    }


    public  void  getCopies(SQLiteDatabase db, int bookId, int branchId) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("SELECT Book_Title, Branch_Name, No_Of_Copies \n" +
                "FROM Book \n" +
                "INNER JOIN Book_Copies ON Book.Book_Id = Book_Copies.Book_Id \n" +
                "INNER JOIN Library_Branch ON Book_Copies.Branch_Id = Library_Branch.Branch_Id \n" +
                "WHERE Book.Book_Id = " + bookId + " AND Library_Branch.Branch_Id =" + branchId + " ?;", null);
        if (allRows.moveToFirst()) {

            do {
                allRows.getString(0);


            } while (allRows.moveToNext());
        }


    }

    public ArrayList<String> getBranchId(SQLiteDatabase db, String branchName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("Select Branch_Id from LIBRARY_BRANCH where Branch_Name=?", new String[]{branchName});
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }

    public ArrayList<String> getBookID(SQLiteDatabase db, String bookName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("Select Book_Id from BOOK where Title=?", new String[]{bookName});
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }

    public ArrayList<String> getTitle(SQLiteDatabase db, String tableName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("SELECT Title FROM " + tableName, null);
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }

    public ArrayList<String> getBranch(SQLiteDatabase db, String tableName) {
        ArrayList<String> list = new ArrayList<>();
        Cursor allRows = db.rawQuery("SELECT Branch_Name FROM " + tableName, null);
        if (allRows.moveToFirst()) {

            do {
                list.add(allRows.getString(0));


            } while (allRows.moveToNext());
        }

        return list;
    }
}