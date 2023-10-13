package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        // Check the database connection
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db != null) {
            Log.d("LMS-LOG", "Database is connected");

            Log.d("LMS-LOG", getTableAsString(db, "Book"));
            Log.d("LMS-LOG", getTableAsString(db, "Book_Authors"));
            Log.d("LMS-LOG", getTableAsString(db, "BOOK_COPIES"));
            Log.d("LMS-LOG", getTableAsString(db, "BOOK_LOANS"));
            Log.d("LMS-LOG", getTableAsString(db, "Publisher"));
            Log.d("LMS-LOG", getTableAsString(db, "Library_Branch"));
            Log.d("LMS-LOG", getTableAsString(db, "Borrower"));


        } else {
            Log.d("LMS-LOG", "Database is not connected");
        }
        checkOutBox();
    }


    private void checkOutBox() {
        binding.button1.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, CheckOutActivity.class);

            startActivity(myIntent);
        });
        binding.button2.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, BorrowerActivity.class);

            startActivity(myIntent);
        });
        binding.button3.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, AddNewBookActivity.class);

            startActivity(myIntent);
        });

        binding.button4.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, LoanedActivity.class);

            startActivity(myIntent);
        });

        binding.button5.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, DateSelectorActivity.class);

            startActivity(myIntent);
        });
        binding.button6.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, LateBalanceActivity.class);

            startActivity(myIntent);
        });
        binding.button7.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, ListBookInfo.class);

            startActivity(myIntent);
        });
    }

    public String getTableAsString(SQLiteDatabase db, String tableName) {
        String tableString = String.format("Table %s:\n", tableName);
        Cursor allRows = db.rawQuery("SELECT * FROM " + tableName, null);
        if (allRows.moveToFirst()) {
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name : columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";


            } while (allRows.moveToNext());
        }

        return tableString;
    }

}