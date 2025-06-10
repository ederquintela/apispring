package br.caixa.gov.apisisra.mapper;

import br.caixa.gov.apisisra.dto.TaskDTO;
import br.caixa.gov.apisisra.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskDTO dto) {
        if (dto == null) {
            return null;
        }

        Task task = new Task();
        task.setId(dto.getId());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
        return task;
    }

    public static TaskDTO toDTO(Task task) {
        if (task == null) {
            return null;
        }

        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.getCompleted());
        return dto;
    }
}
