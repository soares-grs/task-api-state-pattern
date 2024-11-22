package br.com.grs.state_pattern_api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepo;

    @GetMapping
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskDto.Request dto) {
        Task task = taskRepo.save(new Task(dto.getTitle(), dto.getDescription()));
        TaskDto.Response response = TaskMapper.toResponse(task);
        return ResponseEntity.ok().body(response);
    }
}
