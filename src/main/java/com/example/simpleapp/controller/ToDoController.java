package com.example.simpleapp.controller;

import com.example.simpleapp.model.ToDo;
import com.example.simpleapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public List<ToDo> getAllToDos() {
        return toDoService.getAllTodos();
    }

    @PostMapping("/add")
    public String addToDo(@RequestBody ToDo todo) {
        toDoService.addOrUpdateToDo(todo);
        return "Success";
    }

    @PostMapping("/edit/{id}")
    public String editToDo(@PathVariable String id, @RequestBody ToDo todo) {
        todo.setId(id); // Set the ID for updating existing ToDo
        toDoService.addOrUpdateToDo(todo);
        return "Success";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable String id) {
        toDoService.deleteToDoById(id);
        return "Success";
    }
}

