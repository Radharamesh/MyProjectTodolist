package ProjTodolist;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is part of the Todolist project
 * This class holds information about tasks.
 */

public class Task implements Serializable {
    private String taskTitle;
    private LocalDate dueDate;
    private boolean status;
    private String project;

    /**
     * Constructor - initialise and add new tasks.
     */
    public Task(String taskTitle, String dueDate, boolean status, String project) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.taskTitle = taskTitle;
        this.dueDate = LocalDate.parse(dueDate, formatter);
        this.status = status;
        this.project = project;
    }

    public Task() {

    }

    /**
     * @return task title of the current object
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * takes parameter tasktitle and sets it to current object
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * @return task duedate of the current object
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * takes parameter task duedate and sets it to current object
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return task status of the current object
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * takes parameter task status and sets it to current object
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return project name of the current object
     */
    public String getProject() {
        return project;
    }

    /**
     * takes parameter project name and sets it to current object
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Converts objects to string for serialisation
     */
    @Override
    public String toString() {
        return this.taskTitle + " " + this.dueDate + " " + this.status + " " + this.project;
    }
}
