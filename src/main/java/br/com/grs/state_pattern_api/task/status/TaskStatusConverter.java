package br.com.grs.state_pattern_api.task.status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    @Override
    public String convertToDatabaseColumn(TaskStatus attribute) {
        if (attribute == null) return null;
        return attribute.getClass().getSimpleName();
    }

    @Override
    public TaskStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        return switch (dbData) {
            case "Created" -> new Created();
            case "Started" -> new Started();
            case "Concluded" -> new Concluded();
            default -> throw new IllegalArgumentException("Estado desconhecido: " + dbData);
        };
    }
}
