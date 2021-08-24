package edu.ieti.App.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import edu.ieti.App.data.Task;

public interface TaskService {
    Task create(Task task);
    Task findById(AtomicInteger id);
    List<Task> all();
    boolean deleteById(AtomicInteger id);
    Task update(Task task, AtomicInteger id);
}
