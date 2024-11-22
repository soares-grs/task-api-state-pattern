package br.com.grs.state_pattern_api.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class TaskDto {
    @Data
    public static class Response {
        private Long id;

        private String title;

        private String description;

        private String status;
    }

    @Data
    public static class Request {
        @NotBlank(message = "The field title is mandatory")
        private String title;

        private String description;
    }
}
