package com.example.bookeat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TableBookingActivity extends AppCompatActivity {

    private EditText etDate, etTime, etGuests;
    private Button btnBookTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booking);

        // Initialize the views
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etGuests = findViewById(R.id.etGuests);
        btnBookTable = findViewById(R.id.tabelbooking);

        // Table booking button click listener
        btnBookTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString().trim();
                String time = etTime.getText().toString().trim();
                String guests = etGuests.getText().toString().trim();

                if (date.isEmpty() || time.isEmpty() || guests.isEmpty()) {
                    Toast.makeText(TableBookingActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulate booking the table
                    Toast.makeText(TableBookingActivity.this, "Table booked successfully!", Toast.LENGTH_SHORT).show();

                    // Navigate to MenuItemsActivity
                    Intent intent = new Intent(TableBookingActivity.this, LoginActivity.class);
                    startActivity(intent);

                    // Optional: Finish the current activity to prevent back navigation
                    finish();
                }
            }
        });
    }
}
