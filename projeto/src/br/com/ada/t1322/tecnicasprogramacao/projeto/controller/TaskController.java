package br.com.ada.t1322.tecnicasprogramacao.projeto.controller;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

import java.util.Comparator;
import java.util.List;

public interface TaskController {

    void createTask(String title, String description, String deadline, String status);

    List<Task> getAllTasks(Comparator<Task> orderBy);

    List<Task> getTasksByStatus(String status, Comparator<Task> orderBy);
}
