package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {

    public ArrayList<TaskList> taskLists;
    public RecyclerView taskListRv;
    public TaskListAdapter taskListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        handleAddButton();
        setupData();
        setupTaskList();


    }

    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<List<TaskList>> call = todoService.fetchTasks();
        call.enqueue(new Callback<List<TaskList>>() {
            @Override
            public void onResponse(Call<List<TaskList>> call, Response<List<TaskList>> response) {
                List<TaskList> taskLists = response.body();
                taskListAdapter.setData(taskLists);
            }

            @Override
            public void onFailure(Call<List<TaskList>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed to fetch data ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAddButton() {
        Button addBtn = findViewById(R.id.tasklist_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }

    private void setupTaskList() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        taskListAdapter = new TaskListAdapter();
        taskListAdapter.setData(taskLists);
        taskListRv.setAdapter(taskListAdapter);
    }

    private void setupData() {
        taskLists = new ArrayList<>();

    }
}