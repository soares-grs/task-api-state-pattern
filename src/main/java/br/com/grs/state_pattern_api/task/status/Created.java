package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;
import org.springframework.stereotype.Component;


@Component
public class Created implements TaskStatus {

    @Override
    public void next(Task task) {
        task.setStatus(new Started());
    }

}
