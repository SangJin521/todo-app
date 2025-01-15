package com.example.todo_app;

import com.example.todo_app.Todo;
import com.example.todo_app.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // TODO 항목 추가
    public Todo addTodo(String task) {
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    // 모든 TODO 항목 조회
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
}
