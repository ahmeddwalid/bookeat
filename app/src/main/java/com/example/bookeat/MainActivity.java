package com.example.bookeat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle system bars insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize ImageView and set its resource
        ImageView imageView = findViewById(R.id.imageeView);
        imageView.setImageResource(R.drawable.my_imagee);

        // Load the animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.book);

        // Start the animation on the ImageView
        imageView.startAnimation(animation);

        // Move to LoginActivity after animation
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Finish MainActivity to prevent going back to it
        }, 3000); // Adjust the delay to match the animation duration (3 seconds in this example)
    }
}
