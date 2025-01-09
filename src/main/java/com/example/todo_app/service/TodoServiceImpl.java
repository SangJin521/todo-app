package com.example.todo_app.service;

import com.example.todo_app.entity.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    // 생성자 주입 (권장)
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo); // JPA를 사용하여 저장
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll(); // 데이터베이스에서 모든 To-Do 항목 조회
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("To-Do not found with id: " + id));
    }

    @Override
    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id); // 존재하는지 확인
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.getCompleted());
        return todoRepository.save(todo); // 수정 후 저장
    }

    @Override
    public void deleteTodoById(Long id) {
        Todo todo = getTodoById(id); // 존재하는지 확인
        todoRepository.delete(todo); // 삭제
    }
}
