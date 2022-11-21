package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        Button addBtn = findViewById(R.id.add_task_btn);
        addBtn.setOnClickListener(view -> {
            EditText titleTxt = findViewById(R.id.task_txt);
            String title = titleTxt.getText().toString();
            EditText messageTxt = findViewById(R.id.description_txt);
            String message = messageTxt.getText().toString();
            Toast.makeText(this, title + message, Toast.LENGTH_SHORT).show();
        });

    }
}