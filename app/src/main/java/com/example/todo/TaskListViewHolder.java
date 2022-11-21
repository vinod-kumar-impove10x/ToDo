package com.example.todo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTxt;
    public TextView messageTxt;

    public TaskListViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTxt = itemView.findViewById(R.id.title_txt);
        messageTxt = itemView.findViewById(R.id.message_txt);
    }
}
