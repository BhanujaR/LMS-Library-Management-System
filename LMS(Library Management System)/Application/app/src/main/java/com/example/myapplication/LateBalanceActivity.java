package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityLateBalanceBinding;

import java.util.ArrayList;

public class LateBalanceActivity extends AppCompatActivity {
    ActivityLateBalanceBinding binding;

    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLateBalanceBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);
        binding.getLateBalanceAllCustomers.setOnClickListener(view -> {

            String borrowerId = binding.cardNumberBorrower.getText().toString();
            String borrowerName = binding.borrowerName.getText().toString();
//            String sql = "SELECT Borrower.Card_No AS ID, Borrower.Name, "
//                    + "CASE "
//                    + "WHEN COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) <= 0 THEN '$0.00' "
//                    + "ELSE '$' || CAST(COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) AS TEXT) "
//                    + "END AS LateFee "
//                    + "FROM BORROWER "
//                    + "JOIN Book_Loans ON Borrower.Card_No = Book_Loans.Card_No "
//                    + "JOIN Library_Branch ON Library_Branch.Branch_Id = BOOK_LOANS.Branch_Id "
//                    + "WHERE Borrower.Card_No LIKE '%' || COALESCE(?,Borrower.Card_No) || '%' "
//                    + "AND Borrower.Name LIKE '%' || COALESCE(?,Borrower.Name) || '%' "
//                    + "GROUP BY Borrower.Card_No, Borrower.Name "
//                    + "ORDER BY LateFee DESC;";
            String sql = "SELECT * FROM borrowerLateFeeFiltered " +
                    "WHERE (ID LIKE '%' || COALESCE(?, ID) || '%') " +
                    "AND (Name LIKE '%' || COALESCE(?, Name) || '%')";


            Cursor cursor = db.rawQuery(sql, new String[]{borrowerId, borrowerName});
            ArrayList<String> borrowerIds = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> lateFee = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    borrowerIds.add("Borrower ID: " + cursor.getString(0));
                    name.add("Name: " + cursor.getString(1));
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