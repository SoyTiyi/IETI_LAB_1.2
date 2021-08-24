package edu.ieti.App.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import edu.ieti.App.data.Task;
import edu.ieti.App.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

    HashMap<AtomicInteger, Task> tasks = new HashMap<AtomicInteger, Task>();

    @Override
    public Task create(Task task) {
        AtomicInteger size = new AtomicInteger(tasks.size()+1);
        task.setId(size);
        tasks.put(task.getId(), task);
        return tasks.get(task.getId());
    }

    @Override
    public Task findById(AtomicInteger id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> all() {
        List<Task> listTask = new ArrayList<Task>();
        for(AtomicInteger key: tasks.keySet()){
            listTask.add(tasks.get(key));
        }
        return listTask;
    }

    @Override
    public boolean deleteById(AtomicInteger id) {
        try {
            tasks.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Task update(Task task, AtomicInteger id) {
        tasks.replace(id, tasks.get(id), task);
        return tasks.get(id);
    }
    
}
