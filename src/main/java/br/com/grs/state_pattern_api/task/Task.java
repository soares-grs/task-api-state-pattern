package br.com.grs.state_pattern_api.task;

import br.com.grs.state_pattern_api.task.status.Created;
import br.com.grs.state_pattern_api.task.status.TaskStatus;
import br.com.grs.state_pattern_api.task.status.TaskStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    @Convert(converter = TaskStatusConverter.class)
    private TaskStatus status = new Created();

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void changeStatusToNext() {
        this.status.next(this);
    }
}
