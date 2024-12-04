package com.example.bookeat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText fullNameInput, emailInput, passwordInput, confirmPasswordInput;
    private Button signUpButton;
    private TextView signInLink;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize UI elements
        fullNameInput = findViewById(R.id.fullNameInput);
        emailInput = findViewById(R.id.loginEmail);
        passwordInput = findViewById(R.id.loginPassword);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        signUpButton = findViewById(R.id.signUpButton);
        signInLink = findViewById(R.id.SignUpScreen);

        // Set up listener for SignUpScreen Up button
        signUpButton.setOnClickListener(v -> {
            String fullName = fullNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String confirmPassword = confirmPasswordInput.getText().toString().trim();

            // Validate user input
            if (validateSignUp(fullName, email, password, confirmPassword)) {
                // Proceed with sign-up logic
                Toast.makeText(SignUp.this, "SignUpScreen Up Successful", Toast.LENGTH_SHORT).show();

                // Navigate to LoginActivity
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close SignUpActivity
            }
        });

        // Set up listener for SignUpScreen In link
        signInLink.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent intent = new Intent(SignUp.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close SignUpActivity
        });
    }

    // Validate SignUpScreen Up fields
    private boolean validateSignUp(String fullName, String email, String password, String confirmPassword) {
        if (TextUtils.isEmpty(fullName)) {
            fullNameInput.setError("Full Name is required");
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Enter a valid email address");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            return false;
        }
        if (password.length() < 6) {
            passwordInput.setError("Password should be at least 6 characters");
            return false;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordInput.setError("Please confirm your password");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Passwords do not match");
            return false;
        }

        // All validations passed
        return true;
    }
}
