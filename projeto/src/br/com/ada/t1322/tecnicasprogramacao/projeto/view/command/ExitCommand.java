package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.view.IView;

public class ExitCommand implements Command {

    private final IView view;

    public ExitCommand(IView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showMessage("Saindo... 👋");
        System.exit(0);
    }
}
