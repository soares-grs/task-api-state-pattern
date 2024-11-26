package br.com.grs.state_pattern_api.task;

import br.com.grs.state_pattern_api.task.status.TaskStatusFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepo;
    @Autowired
    TaskStatusFacade taskStatusFacade;

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

    @PutMapping("/{taskId}/change-status")
    public ResponseEntity<?> changeStatus(@PathVariable Long taskId) {
        try {
            TaskDto.Response response = taskStatusFacade.processChangeStatus(taskId);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
