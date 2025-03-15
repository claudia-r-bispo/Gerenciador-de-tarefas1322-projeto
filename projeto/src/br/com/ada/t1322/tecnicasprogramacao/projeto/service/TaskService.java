package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task validateAndSave(Task task);

    List<Task> findAll(Comparator<Task> orderBy);

    List<Task> findByStatus(String status, Comparator<Task> orderBy);

    Optional<Task> findById(Long id);

    boolean deleteById(Long id);

    void deleteAll();

    void notifyUpcomingDeadlines();
}
