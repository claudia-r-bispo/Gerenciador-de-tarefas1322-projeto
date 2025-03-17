package br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

public class StatusValidation implements TaskValidation {

    @Override
    public void validate(Task task) {
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Status inválido: não pode ser nulo.");
        }
    }
}
