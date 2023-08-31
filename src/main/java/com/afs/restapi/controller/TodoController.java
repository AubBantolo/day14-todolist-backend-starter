package com.afs.restapi.controller;

import com.afs.restapi.entity.Todo;
import com.afs.restapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        todoService.delete(id);
    }
}
