package br.com.ada.t1322.tecnicasprogramacao.projeto.view;

public interface IView extends AutoCloseable {
    void showMessage(String message);
    String getInput(String prompt);
    int getIntInput(String prompt);
}