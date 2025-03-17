package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.view.View;

public class ExitCommand implements Command {

    private final View view;

    public ExitCommand(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showMessage("Saindo... 👋");
        System.exit(0);
    }
}
