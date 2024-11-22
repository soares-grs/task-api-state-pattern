package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class Started implements TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void create(Task task) {
        throw new RuntimeException("Task has been created");
    }

    public void start(Task task) {
        throw new RuntimeException("Task has been started");
    }

    public void conclude(Task task) {
        task.setStatus(new Concluded());
    }
}
