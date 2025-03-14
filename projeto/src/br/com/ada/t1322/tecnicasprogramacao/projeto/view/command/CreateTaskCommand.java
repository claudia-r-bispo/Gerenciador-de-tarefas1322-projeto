package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.IView;


public class CreateTaskCommand implements Command {

    private final IView view;
    private final TaskController taskController;

    public CreateTaskCommand(IView view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        String title = view.getInput("📌 Informe o título da tarefa");
        String description = view.getInput("📝 Informe a descrição");
        String deadline = view.getInput("📅 Informe a data limite (YYYY-MM-DD)");
        String status = view.getInput("🔄 Informe o status (Pendente, Em andamento, Concluído)");

        try {
            taskController.createTask(title, description, deadline, status);
            view.showMessage("✅ Tarefa criada com sucesso!");
        } catch (IllegalArgumentException e) {
            view.showMessage("❌ Erro: " + e.getMessage());
        }
    }
}
