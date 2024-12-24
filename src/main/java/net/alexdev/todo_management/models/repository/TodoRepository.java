package net.alexdev.todo_management.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.alexdev.todo_management.models.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
