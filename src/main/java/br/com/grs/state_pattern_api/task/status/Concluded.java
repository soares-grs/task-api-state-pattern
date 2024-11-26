package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import org.springframework.stereotype.Component;

@Component
public class Concluded implements TaskStatus  {

    @Override
    public void next(Task task) {
        throw new RuntimeException("Task has been concluded");
    }
}
