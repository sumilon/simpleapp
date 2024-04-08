package com.example.simpleapp.service;

import com.example.simpleapp.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToDoServiceImpl implements ToDoService {

    Map<String, ToDo> toDoList = new HashMap<>();

    @Override
    public List<ToDo> getAllTodos() {

        return new ArrayList<>(toDoList.values());
    }

    @Override
    public ToDo getToDoById(String id) {

        return toDoList.get(id);
    }

    @Override
    public ToDo addOrUpdateToDo(ToDo todo) {

        if(todo.getId()==null) {
            todo.setId(String.valueOf(toDoList.size() + 1));
            toDoList.put(todo.getId(), todo);
        } else {
            toDoList.put(todo.getId(), todo);
        }
        return todo;
    }

    @Override
    public void deleteToDoById(String id) {

        toDoList.remove(id);
    }
}
