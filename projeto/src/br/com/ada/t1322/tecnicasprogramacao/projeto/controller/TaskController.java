package br.com.ada.t1322.tecnicasprogramacao.projeto.controller;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskController {

    void createTask(String title, String description, LocalDate deadline, String status);

    List<Task> getAllTasksSorted();

    List<Task> getTasksByStatus(String status);
}
