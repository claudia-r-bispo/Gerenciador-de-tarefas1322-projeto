package br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import java.util.List;

public class TaskValidator {

    private final List<TaskValidation> validations;

    public TaskValidator(List<TaskValidation> validations) {
        this.validations = validations;
    }

    public void validate(Task task) {
        for (TaskValidation validation : validations) {
            validation.validate(task);
        }
    }
}
