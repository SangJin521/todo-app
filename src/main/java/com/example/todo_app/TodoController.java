package com.example.todo_app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    // TODO 항목 추가
    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@RequestParam String task) {
        Todo todo = todoService.addTodo(task);
        return ResponseEntity.ok(todo);
    }

    // 모든 TODO 항목 조회
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getTodos();
        return ResponseEntity.ok(todos);
    }
}
