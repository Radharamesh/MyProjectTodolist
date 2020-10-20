package ProjTodolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is part of the Todolist project
 * This parser reads user input
 * Every time it is called it reads a line from the terminal
 * It returns the option to choose task manipulation.
 */


public class Parser {
    private Scanner inputReader;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        inputReader = new Scanner(System.in);
    }

    /**
     * @return The next option from the user.
     */
    public int getOption() {
        int option;
        option = inputReader.nextInt();
        return option;
    }
    /**
     * Prints welcome message and prints number of tasks to be done and number of tasks done.
     * And prints options for tasks manipulation.
     */
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

    /**
     * @return The next option from user to add another task after adding a new task.
     */
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

    /**
     * @return The next option from user to update and remove tasks.
     */
    public int updateOrRemoveTask() {
        int editOption;
        System.out.println("Do you want to update or remove task? (Update : 1, Remove : 2)");
        editOption = inputReader.nextInt();
        return editOption;
    }
    /**
     * @return The next option from user to show tasks by date or project.
     */
    public int optionShowTask() {
        int showOption;
        System.out.println("Display by project or date? (Project : 1, Duedate : 2)");
        showOption = inputReader.nextInt();
        return showOption;
    }
    /**
     * @return The next option from user to choose fields to update.
     */
    public int taskFieldToEdit() {
        int editFieldOption;
        System.out.println("Which field you want to update? (Task Title : 1, Status : 2)");
        editFieldOption = inputReader.nextInt();
        return editFieldOption;

    }

    /**
     * @return The updated new task title from user to update the existing task title field
     * in the corresponding task.
     */
    public String getTaskTitleToUpdate() {
        String taskTitle;
        System.out.println(">> Enter Task Title to update : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    /**
     * @return The updated new task status from user to update task status field as done or tobedone
     * in the corresponding task.
     */
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

    /**
     * @return The task title from user in which user wants to update and remove tasks.
     */
    public String getTaskTitleToEdit() {
        String taskTitle;
        System.out.println(">> Enter which task you want to update : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    /**
     * @return The task title from user which user wants to remove from task list.
     */
    public String getTaskTitleToRemove() {
        String taskTitle;
        System.out.println(">> Enter which task you want to remove : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }

    /**
     * @return The input task title from user while adding new task.
     */
    public String getTaskTitle() {
        String taskTitle;
        System.out.println(">> Enter Task Title : ");
        taskTitle = inputReader.next();
        return taskTitle;
    }
    /**
     * @return The input task duedate from user while adding new task.
     */
    public String getTaskDuedate() {
        String dueDate;
        System.out.println(">> Enter Due Date of Task in yyyy-MM-dd pattern");
        dueDate = inputReader.next();
        return dueDate;
    }

    /**
     * @return The input task status from user while adding new task.
     */
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

    /**
     * @return The input Projectname from user while adding new task.
     */
    public String getTaskProject() {
        String project;
        System.out.println("Enter Project name of Task");
        project = inputReader.next();
        return project;
    }




}
