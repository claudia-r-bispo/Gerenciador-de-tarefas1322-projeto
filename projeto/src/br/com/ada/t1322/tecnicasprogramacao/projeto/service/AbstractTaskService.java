package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public abstract class AbstractTaskService implements TaskService {

    protected final TaskRepository taskRepository;

    public AbstractTaskService(TaskRepository taskRepository) {
        if (taskRepository == null) {
            throw new IllegalArgumentException("TaskRepository não pode ser nulo.");
        }
        this.taskRepository = taskRepository;
    }

    @Override
    public final Task validateAndSave(Task task) {
        validateTask(task);
        return taskRepository.save(task);
    }

    protected abstract void validateTask(Task task);

    @Override
    public List<Task> findAll(Comparator<Task> orderBy) {
        return taskRepository.findAll().stream()
                .sorted(orderBy)
                .toList();
    }

    @Override
    public List<Task> findByStatus(String status, Comparator<Task> orderBy) {
        return taskRepository.findByStatus(status).stream()
                .sorted(orderBy)
                .toList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        return taskRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }

    @Override
    public void notifyUpcomingDeadlines() {
        // Implementação futura para notificações
    }
}
