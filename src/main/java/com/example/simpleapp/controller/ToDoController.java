package com.example.simpleapp.controller;

import com.example.simpleapp.model.ToDo;
import com.example.simpleapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public String getAllToDos(Model model) {
        model.addAttribute("todos", toDoService.getAllTodos());
        return "todos";
    }

    @GetMapping("/all")
    public List<ToDo> getAll() {
        return toDoService.getAllTodos();
    }

    @PostMapping("/add")
    public String addToDo(@ModelAttribute ToDo todo) {
        toDoService.addOrUpdateToDo(todo);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editToDo(@PathVariable String id, @ModelAttribute ToDo todo) {
        todo.setId(id); // Set the ID for updating existing ToDo
        toDoService.addOrUpdateToDo(todo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable String id) {
        toDoService.deleteToDoById(id);
        return "redirect:/";
    }
}

