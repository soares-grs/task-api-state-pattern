package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import br.com.grs.state_pattern_api.task.TaskDto;
import br.com.grs.state_pattern_api.task.TaskMapper;
import br.com.grs.state_pattern_api.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskStatusFacade {

    @Autowired
    TaskRepository taskRepo;

    public TaskDto.Response processChangeStatus(Long taskId) throws Exception {
        Optional<Task> task = taskRepo.findById(taskId);

        if (task.isEmpty()) {
            throw new Exception("Task was not found");
        }

        task.get().changeStatusToNext();

        taskRepo.save(task.get());
        return TaskMapper.toResponse(task.get());
    }
}
