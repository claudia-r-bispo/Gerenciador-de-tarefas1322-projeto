package br.com.ada.t1322.tecnicasprogramacao.projeto.view;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConsoleApp {

    private final IView view;
    private final Map<Integer, Command> commands = new HashMap<>();

    public ConsoleApp(IView view, TaskController taskController) {
        this.view = view;
        initializeCommands(view, taskController);
    }

    private void initializeCommands(IView view, TaskController taskController) {
        commands.put(1, new CreateTaskCommand(view, taskController));
        commands.put(2, new ListTasksCommand(view, taskController));
        commands.put(3, new FilterTasksByStatusCommand(view, taskController));
        commands.put(4, new ExitCommand(view));
    }

    public void run() {
        while (true) {
            view.showMessage("\n📌 Gerenciador de Tarefas Inteligente");
            view.showMessage("1 - Criar Tarefa");
            view.showMessage("2 - Listar Tarefas Ordenadas");
            view.showMessage("3 - Filtrar por Status");
            view.showMessage("4 - Sair");

            int option = view.getIntInput("Escolha uma opção");

            Optional.ofNullable(commands.get(option))
                    .ifPresentOrElse(Command::execute,
                            () -> view.showMessage("❌ Opção inválida. Tente novamente."));

        }
    }
}
