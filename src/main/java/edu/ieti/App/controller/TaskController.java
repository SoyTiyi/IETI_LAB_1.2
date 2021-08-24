package edu.ieti.App.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ieti.App.data.Task;
import edu.ieti.App.dto.TaskDto;
import edu.ieti.App.service.TaskService;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<?> all(){
        try {
            return new ResponseEntity<>(taskService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<?> findById(@PathVariable String id){
        try {
            return new ResponseEntity<>(taskService.findById(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create( @RequestBody TaskDto taskDto ){
        try {
            Task task = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getStatus(), taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.isCreated());
            return new ResponseEntity<>(taskService.create(task),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update( @RequestBody TaskDto taskDto, @PathVariable String id ){
        try {
            Task task = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getStatus(), taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.isCreated());
            return new ResponseEntity<>(taskService.update(task, id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete( @PathVariable String id ){
        try {
            return new ResponseEntity<>(taskService.deleteById(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
