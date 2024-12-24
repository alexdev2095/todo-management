package net.alexdev.todo_management.models.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.alexdev.todo_management.exception.ResourceNotFoundException;
import net.alexdev.todo_management.models.dto.TodoDto;
import net.alexdev.todo_management.models.entity.Todo;
import net.alexdev.todo_management.models.mapper.TodoMapper;
import net.alexdev.todo_management.models.repository.TodoRepository;
import net.alexdev.todo_management.models.service.TodoService;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = TodoMapper.mapToTodo(todoDto);

        // Todo jpa Entity
        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = TodoMapper.mapToTodoDto(savedTodo);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with: " + id));

        TodoDto todoDto = TodoMapper.mapToTodoDto(todo);

        return todoDto;
    }

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(TodoMapper::mapToTodoDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with: " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with: " + id));

        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completedTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with: " + id));

        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public TodoDto inCompletedTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with: " + id));

        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(updatedTodo);
    }

}
