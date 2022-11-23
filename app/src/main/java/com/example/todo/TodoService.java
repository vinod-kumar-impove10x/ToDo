package com.example.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TodoService {
    @GET("vinodtodo")
    Call<List<TaskList>> fetchTasks();

    @POST("vinodTodo")
    Call<TaskList> createTask(@Body TaskList taskList);
}

