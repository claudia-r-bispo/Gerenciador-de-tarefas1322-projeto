package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.IView;

import java.util.List;

public class ListTasksCommand implements Command {

    private final IView view;
    private final TaskController taskController;

    public ListTasksCommand(IView view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        List<Task> tasks = taskController.getAllTasksSorted();
        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }
}
