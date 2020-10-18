package ProjTodolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Parser {
    private Scanner inputReader;

    public Parser() {
        inputReader = new Scanner(System.in);
    }

    public int getOption() {
        int option;
        option = inputReader.nextInt();
        return option;
    }

    public void printWelcome(int tasksToBeDone, int tasksDone) {
        System.out.println();
        System.out.println(">> Welcome to Todolist");
        System.out.printf(">> You have %d tasks todo and %d tasks are done!\n", tasksToBeDone, tasksDone);
        System.out.println(">> Pick an option: ");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println();
    }

    public boolean addAnotherTask() {
        String addTasks;
        System.out.println("Do you want to add another task (Y/N) ?");
        addTasks = inputReader.next();
        addTasks = addTasks.toUpperCase();
        if (addTasks.contentEquals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public int updateOrRemoveTask() {
        int editOption;
        System.out.println("Do you want to update or remove task (Update : 1, Remove : 2)");
        editOption = inputReader.nextInt();
        return editOption;
    }

    public int taskFieldToEdit() {
        int editFieldOption;

        System.out.println("Which field do you want to update (Task Title : 1, Status : 2)");
        editFieldOption = inputReader.nextInt();
        return editFieldOption;

    }

    public String getTaskTitleToUpdate() {
        String taskTitle;
        System.out.println(">> Enter Task Title to update : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    public boolean getTaskStatusToUpdate() {
        boolean status = false;
        System.out.println("Enter Status to edit (Done - True/Tobedone -False)");
        try {
            status = inputReader.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }

        return status;
    }

    public String getTaskTitleToEdit() {
        String taskTitle;
        System.out.println(">> Enter which task you want to update : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    public String getTaskTitleToRemove() {
        String taskTitle;
        System.out.println(">> Enter which task you want to remove : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    public String getTaskTitle() {
        String taskTitle;
        System.out.println(">> Enter Task Title : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    public String getTaskDuedate() {
        String dueDate;
        System.out.println(">> Enter Due Date of Task in yyyy-MM-dd pattern");
        dueDate = inputReader.next();
        return dueDate;
    }

    public boolean getTaskStatus() {
        boolean status = false;
        System.out.println("Enter Status of Project (Done - True/Tobedone -False)");
        try {
            status = inputReader.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }

        return status;
    }

    public String getTaskProject() {
        String project;
        System.out.println("Enter Project name of Task");
        project = inputReader.next();
        return project;
    }


}
