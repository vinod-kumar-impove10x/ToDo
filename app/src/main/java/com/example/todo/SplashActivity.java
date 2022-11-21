package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        // Create Handler Object
        Handler handler = new Handler();
        // Call postDelayed method
        handler.postDelayed( () -> {
            // This will execute after 5000 ms
            Intent intent = new Intent(this,TaskListActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}