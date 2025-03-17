package br.com.ada.t1322.tecnicasprogramacao.projeto.view;

public interface View extends AutoCloseable {
    void showMessage(String message);
    String getInput(String prompt);
    Integer getIntInput(String prompt);
}