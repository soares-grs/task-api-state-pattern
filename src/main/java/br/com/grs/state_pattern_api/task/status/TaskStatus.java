package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;

public interface TaskStatus {
    void next(Task task);
}
