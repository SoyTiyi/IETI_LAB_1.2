package edu.ieti.App.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.ieti.App.data.Task;
import edu.ieti.App.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

    HashMap<String, Task> tasks = new HashMap<String, Task>();

    @Override
    public Task create(Task task) {
        int intId = tasks.size()+1;
        task.setId(intId+"");
        tasks.put(task.getId(), task);
        return tasks.get(task.getId());
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> all() {
        List<Task> listTask = new ArrayList<Task>();
        for(String key: tasks.keySet()){
            listTask.add(tasks.get(key));
        }
        return listTask;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            tasks.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Task update(Task task, String id) {
        task.setId(id);
        tasks.replace(id, tasks.get(id), task);
        return tasks.get(id);
    }
    
}
