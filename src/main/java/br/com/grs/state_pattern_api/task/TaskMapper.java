package br.com.grs.state_pattern_api.task;

public class TaskMapper {

    public static TaskDto.Response toResponse(Task task) {
        TaskDto.Response response = new TaskDto.Response();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());

        response.setStatus(task.getStatus() != null ? task.getStatus().getClass().getSimpleName() : null);

        return response;
    }
}
