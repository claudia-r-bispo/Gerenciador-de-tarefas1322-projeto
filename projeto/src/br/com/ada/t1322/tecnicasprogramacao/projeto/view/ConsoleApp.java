package br.com.ada.t1322.tecnicasprogramacao.projeto.view;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.TaskComparators;

import java.util.Comparator;
import java.util.List;

public class ConsoleApp {

    private final IView view;
    private final TaskController taskController;

    public ConsoleApp(IView view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    public void run() {
        while (true) {
            view.showMessage("\n📌 Gerenciador de Tarefas Inteligente");
            view.showMessage("1 - Criar Tarefa");
            view.showMessage("2 - Listar Tarefas Ordenadas");
            view.showMessage("3 - Filtrar por Status");
            view.showMessage("4 - Sair");

            int option = view.getIntInput("Escolha uma opção");

            switch (option) {
                case 1 -> createTask();
                case 2 -> listAllTasks();
                case 3 -> filterTasksByStatus();
                case 4 -> {
                    view.showMessage("Saindo... 👋");
                    return;
                }
                default -> view.showMessage("❌ Opção inválida. Tente novamente.");
            }
        }
    }

    private void createTask() {
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

    private void listAllTasks() {
        Comparator<Task> orderBy = getSortingMethod();
        List<Task> tasks = taskController.getAllTasks(orderBy);

        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }

    private void filterTasksByStatus() {
        String status = view.getInput("🔎 Digite o status para filtrar");
        Comparator<Task> orderBy = getSortingMethod();
        List<Task> tasks = taskController.getTasksByStatus(status, orderBy);

        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada com esse status.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }

    private Comparator<Task> getSortingMethod() {
        view.showMessage("Escolha o critério de ordenação:");
        view.showMessage("1 - Por Data Limite");
        view.showMessage("2 - Por Título");
        view.showMessage("3 - Por Status");

        int option = view.getIntInput("Digite o número da opção");

        view.showMessage("Deseja ordem reversa? (S/N)");
        boolean reversed = view.getInput("").trim().equalsIgnoreCase("S");

        String criteria = switch (option) {
            case 2 -> "title";
            case 3 -> "status";
            default -> "deadline";
        };

        return TaskComparators.getComparator(criteria, reversed);
    }
}
