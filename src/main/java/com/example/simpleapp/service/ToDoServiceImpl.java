package com.example.simpleapp.service;

import com.example.simpleapp.model.ToDo;
import com.example.simpleapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(String id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        return optionalToDo.orElse(null);
    }

    @Override
    public ToDo addOrUpdateToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public void deleteToDoById(String id) {
        toDoRepository.deleteById(id);
    }
}
