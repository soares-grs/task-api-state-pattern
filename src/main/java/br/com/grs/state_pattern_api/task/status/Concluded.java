package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import org.springframework.stereotype.Component;

@Component
public class Concluded implements TaskStatus  {

    public void create(Task task) {
        throw new RuntimeException("Task has been created");
    }

    public void start(Task task) {
        throw new RuntimeException("Task has been started");
    }

    public void conclude(Task task) {
        throw new RuntimeException("Task has been concluded");
    }
}
