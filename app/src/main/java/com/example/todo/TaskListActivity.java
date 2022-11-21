package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

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
        TaskList title1 = new TaskList();
        title1.titleTxt= "Get vegetables";
        title1.messageTxt = "for 1 week";
        taskLists.add(title1);

        TaskList title2 = new TaskList();
        title2.titleTxt= "Reading news";
        title2.messageTxt = "Explore politics, filmy and sports news";
        taskLists.add(title2);

        TaskList title3 = new TaskList();
        title3.titleTxt= "Prepare lunch";
        title3.messageTxt = "Biryani and Raitha.yummyyy";
        taskLists.add(title3);

        TaskList title4 = new TaskList();
        title4.titleTxt= "Have Breakfast";
        title4.messageTxt = "Healthy breakfast for a better morning";
        taskLists.add(title4);
    }
}