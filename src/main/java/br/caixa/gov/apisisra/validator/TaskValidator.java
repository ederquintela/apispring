package br.caixa.gov.apisisra.validator;

import br.caixa.gov.apisisra.dto.TaskDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.caixa.gov.apisisra.model.Task;

@Component
public class TaskValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        TaskDTO task = (TaskDTO) target;

        // Adicione validações personalizadas se necessário
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
            errors.rejectValue("description", "description.empty", "A descrição não pode estar em branco");
        }

        // Exemplos adicionais de validação
        if (task.getCompleted() == null) {
            errors.rejectValue("completed", "completed.null", "O status completed não pode ser nula");
        }

    }

}
