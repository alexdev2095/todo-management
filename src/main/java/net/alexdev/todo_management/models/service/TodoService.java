package net.alexdev.todo_management.models.service;

import java.util.List;

import net.alexdev.todo_management.models.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto completedTodo(Long id);

    TodoDto inCompletedTodo(Long id);
}
