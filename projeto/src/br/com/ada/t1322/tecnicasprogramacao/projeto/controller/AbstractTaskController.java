package br.com.ada.t1322.tecnicasprogramacao.projeto.controller;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.TaskService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractTaskController implements TaskController {

    protected final TaskService taskService;

    public AbstractTaskController(TaskService taskService) {
        if (taskService == null) {
            throw new IllegalArgumentException("TaskService não pode ser nulo.");
        }
        this.taskService = taskService;
    }

    @Override
    public final void createTask(String title, String description, String deadline, String status) {
        validateTitle(title);
        validateDescription(description);
        validateDeadline(deadline);
        validateStatus(status);

        Task task = new Task(null, title, description, LocalDate.parse(deadline), Task.Status.fromString(status));
        taskService.validateAndSave(task);
    }

    protected abstract void validateTitle(String title);

    protected abstract void validateDescription(String description);

    protected abstract void validateDeadline(String deadline);

    protected abstract void validateStatus(String status);

    @Override
    public List<Task> getAllTasks(Comparator<Task> orderBy) {
        return taskService.findAll(orderBy);
    }

    @Override
    public List<Task> getTasksByStatus(String status, Comparator<Task> orderBy) {
        return taskService.findByStatus(status, orderBy);
    }
}
