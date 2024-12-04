package com.example.bookeat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private Button loginButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);

        // Handle Login button click
        loginButton.setOnClickListener(v -> {
            String username = loginEmail.getText().toString().trim();
            String password = loginPassword.getText().toString().trim();

            // Validate inputs
            if (validateLogin(username, password)) {
                // Show login success toast
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Navigate to TableBookingActivity
                Intent intent = new Intent(LoginActivity.this, TableBookingActivity.class);
                startActivity(intent);
                finish(); // Optional: Prevent back navigation to login screen
            }
        });


        // Handle SignUpScreen Up button click
        signUpButton.setOnClickListener(v -> {
            // Navigate to SignUpActivity
            Intent intent = new Intent(LoginActivity.this, SignUp.class);
            startActivity(intent);
        });
    }

    // Validate Login inputs
    private boolean validateLogin(String username, String password) {
        if (username.isEmpty()) {
            loginEmail.setError("Email is required");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            loginEmail.setError("Enter a valid email address");
            return false;
        }
        if (password.isEmpty()) {
            loginPassword.setError("Password is required");
            return false;
        }
        if (password.length() < 6) {
            loginPassword.setError("Password must be at least 6 characters");
            return false;
        }

        return true;
    }
}
