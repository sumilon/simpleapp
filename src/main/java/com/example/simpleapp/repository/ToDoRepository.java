package com.example.simpleapp.repository;

import com.example.simpleapp.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
