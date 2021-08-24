package edu.ieti.App.dto;

import java.sql.Date;

import edu.ieti.App.status.Status;

public class TaskDto {
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private Date dueDate;
    private boolean created;

    public TaskDto(){

    }

    public TaskDto(String name, String description,Status status, String assignedTo, Date dueDate, boolean created){
        setName(name);
        setDescription(description);
        setStatus(status);
        setAssignedTo(assignedTo);
        setDueDate(dueDate);
        setCreated(created);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public boolean isCreated() {
        return created;
    }
    public void setCreated(boolean created) {
        this.created = created;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setName(String name) {
        this.name = name;
    }
}
