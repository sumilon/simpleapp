package com.example.simpleapp.service;

import com.example.simpleapp.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllTodos();
    ToDo getToDoById(String id);
    ToDo addOrUpdateToDo(ToDo todo);
    void deleteToDoById(String id);
}
