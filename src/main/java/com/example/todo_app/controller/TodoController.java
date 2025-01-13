package com.example.todo_app.controller;

import com.example.todo_app.entity.Todo;
import com.example.todo_app.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    // TODO 항목 추가
    @PostMapping("/add")
    public Todo addTodo(@RequestParam String task) {
        Todo todo = new Todo();
        todo.setTask(task); // todo 저장
        todo.setCompleted(false); // 새로 추가된 TODO 진행상황은 미진행(false)상태로 지정
        todoRepository.save(todo); // 데이터베이스에 저장
        return todo; // 추가된 TODO 항목 반환
    }

    // 모든 TODO 항목 조회
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.findAll(); // JSON 형식으로 반환
    }
}
