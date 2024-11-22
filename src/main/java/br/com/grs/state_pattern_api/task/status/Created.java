package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import org.springframework.stereotype.Component;


@Component
public class Created implements TaskStatus {

    public void create(Task task) {
        throw new RuntimeException("Task has been created");
    }

    public void start(Task task) {
        task.setStatus(new Started());
    }

    public void conclude(Task task) {
        throw new RuntimeException("Task must be started to change status to concluded");

    }
}
