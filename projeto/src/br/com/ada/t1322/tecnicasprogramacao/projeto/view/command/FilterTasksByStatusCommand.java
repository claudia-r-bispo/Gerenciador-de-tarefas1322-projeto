package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.IView;

import java.util.List;

public class FilterTasksByStatusCommand implements Command {

    private final IView view;
    private final TaskController taskController;

    public FilterTasksByStatusCommand(IView view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        String status = view.getInput("🔎 Digite o status para filtrar");
        List<Task> tasks = taskController.getTasksByStatus(status);
        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada com esse status.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }
}
