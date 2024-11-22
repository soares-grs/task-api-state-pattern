package br.com.grs.state_pattern_api.task.status;

import br.com.grs.state_pattern_api.task.Task;

public interface TaskStatus {
    void create(Task task);

    void start(Task task);

    void conclude(Task task);
}
