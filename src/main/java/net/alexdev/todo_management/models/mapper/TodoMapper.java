package net.alexdev.todo_management.models.mapper;

import net.alexdev.todo_management.models.dto.TodoDto;
import net.alexdev.todo_management.models.entity.Todo;

public class TodoMapper {

    public static TodoDto mapToTodoDto(Todo todo) {

        TodoDto todoDto = new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());

        return todoDto;

    }

    public static Todo mapToTodo(TodoDto todoDto) {
        Todo todo = new Todo(todoDto.getId(), todoDto.getTitle(), todoDto.getDescription(), todoDto.isCompleted());

        return todo;
    }
}
