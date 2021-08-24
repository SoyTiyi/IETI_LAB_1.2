package edu.ieti.App.data;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicInteger;

import edu.ieti.App.status.Status;

public class Task {
    private AtomicInteger id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private Date dueDate;
    private boolean created;

    public Task() {

    }

    public Task(String name, String description, Status status, String assignedTo, Date dueDate,
            boolean created) {
        setName(name);
        setDescription(description);
        setStatus(status);
        setAssignedTo(assignedTo);
        setDueDate(dueDate);
        setCreated(created);
    }

    public AtomicInteger getId() {
        return id;
    }

    public void setId(AtomicInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
}
