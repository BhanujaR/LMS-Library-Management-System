package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.databinding.ActivityDateSelectorBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class DateSelectorActivity extends AppCompatActivity {
    ActivityDateSelectorBinding binding;
    final Calendar myCalendar = Calendar.getInstance();
    ArrayList<String> borrowerIds = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> lateFee = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateSelectorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        DatePickerDialog.OnDateSetListener startDate = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateStartLabel();
        };
        DatePickerDialog.OnDateSetListener endDate = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updatEndLabel();
        };
        binding.selectStartDate.setOnClickListener(view -> new DatePickerDialog(DateSelectorActivity.this, startDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        binding.selectEndDate.setOnClickListener(view -> new DatePickerDialog(DateSelectorActivity.this, endDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(this, borrowerIds, name, lateFee);
        recyclerView.setAdapter(customAdapter);
        binding.getDetails.setOnClickListener(view -> {

            String sql = "SELECT Book_Id, Branch_Id, Card_No, julianday(Returned_Date) - julianday(Due_Date) AS DaysLate FROM Book_Loans WHERE Returned_Date > ? AND Returned_Date < ? AND Returned_Date > Due_Date;";

            String[] selectionArgs = {binding.selectStartDate.getText().toString(), binding.selectEndDate.getText().toString()};
            Cursor cursor = db.rawQuery(sql, selectionArgs);
            if (cursor.moveToFirst()) {
                do {
                    borrowerIds.add("Book id : " + cursor.getString(0));
                    name.add("Branch ID: " + cursor.getString(1) +  "\n" +"Card ID: " + cursor.getString(2) );
                    lateFee.add("Days Left: " + cursor.getString(3));

                } while (cursor.moveToNext());

                customAdapter.borrowerID = borrowerIds;
                customAdapter.name = name;
                customAdapter.lateFee = lateFee;
                customAdapter.notifyDataSetChanged();
            }
        });
    }

    private void updateStartLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        binding.selectStartDate.setText(dateFormat.format(myCalendar.getTime()));
    }
    private void updatEndLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        binding.selectEndDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}