package br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import java.time.LocalDate;

public class DeadlineValidation implements TaskValidation {

    @Override
    public void validate(Task task) {
        LocalDate deadline = task.getDeadline();
        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida: '" + deadline + "'. Deve ser maior ou igual à data atual.");
        }
    }
}
