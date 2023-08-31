package com.afs.restapi.service;

import com.afs.restapi.entity.Todo;
import com.afs.restapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Integer id, Todo todo) {
        Todo itemToUpdate = todoRepository.findById(id).orElseThrow();
        itemToUpdate.setText(todo.getText());
        itemToUpdate.setDone(todo.getDone());
        System.out.println(itemToUpdate);
        return todoRepository.save(itemToUpdate);
    }

    public void delete(Integer id){
        todoRepository.deleteById(id);
    }

}
