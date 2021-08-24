package edu.ieti.App.service;

import java.util.List;
import edu.ieti.App.data.Task;

public interface TaskService {
    Task create(Task task);
    Task findById(String id);
    List<Task> all();
    boolean deleteById(String id);
    Task update(Task task, String id);
}
