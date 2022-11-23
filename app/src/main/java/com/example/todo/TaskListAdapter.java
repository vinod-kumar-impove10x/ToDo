package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListViewHolder> {

    public List<TaskList> taskLists;

    public void setData(List<TaskList> tasksList) {
        taskLists = tasksList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklist_item,parent,false);
        TaskListViewHolder taskListViewHolder = new TaskListViewHolder(view);
        return taskListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TaskList taskList = taskLists.get(position);
        holder.titleTxt.setText(taskList.titleTxt);
        holder.messageTxt.setText(taskList.messageTxt);

    }

    @Override
    public int getItemCount() {
        return taskLists.size();
    }
}
