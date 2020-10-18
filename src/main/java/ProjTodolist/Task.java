package ProjTodolist;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Task implements Serializable {
    private String taskTitle;
    private LocalDate dueDate;
    private boolean status;
    private String project;

    public Task(String taskTitle, String dueDate, boolean status, String project) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.taskTitle = taskTitle;
        this.dueDate = LocalDate.parse(dueDate, formatter);
        this.status = status;
        this.project = project;
    }

    public Task() {

    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return this.taskTitle + " " + this.dueDate + " " + this.status + " " + this.project;
    }
}
