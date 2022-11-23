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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            createTask(title, message);
        });

    }

    public void createTask(String title, String message) {
        TaskList taskList = new TaskList();
        taskList.titleTxt = title;
        taskList.messageTxt = message;

        TodoApi todoApi = new TodoApi();
        TodoService service = todoApi.createTodoService();
        Call<TaskList> call = service.createTask(taskList);
        call.enqueue(new Callback<TaskList>() {
            @Override
            public void onResponse(Call<TaskList> call, Response<TaskList> response) {
                Toast.makeText(AddTaskActivity.this, "Successfully added task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<TaskList> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}