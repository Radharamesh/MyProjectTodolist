package ProjTodolist;


import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;

/**
 *  This class is the main class of the "Todolist project".
 *  "Todolist" is a very simple, text based application
 *  It gets options from user using scanner to add, edit, remove and save tasks
 *  This main class creates and initialises all the others.
 *  */
public class MainMenu {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static boolean quit = false;
    private static boolean addTasks = true;

    /**
     *  Main method runs when application initiates run and loops until user choose to save and quit.
     */
    public static void main(String[] args) throws Exception {
        int option;
        int tasksToBeDoneSize = 0;
        int tasksDoneSize = 0;

        Parser parser = new Parser();

        //Check for file existance and reads from text file and store it in an arraylist.
        FileHandler readFileHandler = new FileHandler();
        if (readFileHandler.fileExists() == true) {
            taskList = readFileHandler.readAsObject();
        }

        /*If user runs application gets number of tasks done, tobedone and
        prints it along with welcome message, then process the user input option.
         */
        while (quit == false) {
            tasksDoneSize = getSizeOfTasksDone(taskList);
            tasksToBeDoneSize = getSizeOfTasksToBeDone(taskList);
            parser.printWelcome(tasksToBeDoneSize, tasksDoneSize);
            option = parser.getOption();
            processOption(option, parser);
        }
    }

    /**
     * Given an option, process (that is: execute) the option.
     * parameter option to be processed.
     * Based on the option the process for adding,editing,removing and saving tasks will be carried out.
     */
    private static void processOption(int option, Parser parser) throws Exception {
        switch (option) {
            case 1:
                //Showing tasks by date and project
                showTask(parser);
                break;
            case 2:
                //Adding tasks and store it in an arraylist of task objects.
                addTask(parser);
                break;
            case 3:
                //Editing tasks for updating task title and status or removing tasks
                editAndRemoveTask(parser);
                break;
            case 4:
                //Save tasks in text file and quits from application.
                saveAndQuit(parser);
                break;
            default:
                System.out.println("Invalid option");

        }

    }

    /**
     * Calling methods in filehandler class to save tasks in text file and quits from application.
     */
    private static void saveAndQuit(Parser parser) {
        if (taskList.size() != 0) {
            FileHandler writeFileHandler = new FileHandler();
            writeFileHandler.writeAsObject(taskList);
        }
        quit = true;
    }

    /**
     * Adding tasks and store it in an arraylist of task objects.
     */
    private static void addTask(Parser parser) {
        String taskTitle;
        String dueDate;
        boolean status;
        String project;

        while (addTasks == true) {

            taskTitle = parser.getTaskTitle();
            dueDate = parser.getTaskDuedate();
            //status = parser.getTaskStatus();
            status = false;
            project = parser.getProjectName();

            Task ts = new Task(taskTitle, dueDate, status, project);
            taskList.add(ts);
            System.out.println("Task added");
            addTasks = parser.addAnotherTask();
        }
    }

    /**
     * Editing tasks for updating task title and status or removing tasks
     */
    private static void editAndRemoveTask(Parser parser) {
        int editOption;
        String taskToEdit;
        String taskTitleToUpdate;
        String taskToRemove;
        boolean taskStatusToUpdate = false;
        int taskFieldToEdit;
        editOption = parser.updateOrRemoveTask();

        switch (editOption) {
            case 1:
                //Update
                showTaskListByProj();
                taskToEdit = parser.getTaskToEdit();

                taskFieldToEdit = parser.taskFieldToEdit();
                if (taskFieldToEdit == 1) {
                    taskTitleToUpdate = parser.getTaskTitleToUpdate();
                    for (Task task : taskList) {
                        if (task != null && taskToEdit.equals(task.getTaskTitle())) {
                            task.setTaskTitle(taskTitleToUpdate);
                            break;
                        }
                    }
                } else {
                    taskStatusToUpdate = parser.getTaskStatusToUpdate();
                    for (Task task : taskList) {
                        if (task != null && taskToEdit.equals(task.getTaskTitle())) {
                            task.setStatus(taskStatusToUpdate);
                            break;
                        }
                    }
                }
                System.out.printf("Task %s updated", taskToEdit);
                break;
            case 2:
                //Remove
                showTaskListByProj();
                taskToRemove = parser.getTaskToRemove();
                for (Task task : taskList) {
                    if (task != null && taskToRemove.equals(task.getTaskTitle())) {
                        taskList.remove(task);
                        break;
                    }
                }
                System.out.printf("Task %s removed", taskToRemove);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    /**
     * Displaying tasks by date and project based on user option.
     */
    private static void showTask(Parser parser) {
            int showOption;
            showOption = parser.optionShowTask();
            switch (showOption) {
                case 1 :
                    showTaskListByProj();
                    break;
                case 2 :
                    showTaskListByDate();
                    break;
                default:
                    System.out.println("Invalid option");
            }
    }

    /**
     * Sorts tasks list by project and prints tasks lists.
     */
    private static void showTaskListByProj() {
        System.out.println("Task list by project");
        List<Task> sortListByProj = taskList.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .collect(Collectors.toList());

        for (Task task : sortListByProj) {
            if (task != null) {
                String taskStatus = task.getStatus() ? "Done" : "Tobedone";
                System.out.println("Task Title : " + task.getTaskTitle() + " " +
                        "Task Duedate : " + task.getDueDate() + " " +
                        "Task status : " + taskStatus + " " +
                        "Project : " + task.getProject());
            }
        }

    }

    /**
     * Sorts tasks list by date and prints tasks lists.
     */
    private static void showTaskListByDate() {
        System.out.println("Task list by date");
        List<Task> sortListByDate = taskList.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());

        for (Task task : sortListByDate) {
            if (task != null) {
                String taskStatus = task.getStatus() ? "Done" : "Tobedone";
                System.out.println("Task Title : " + task.getTaskTitle() + " " +
                        "Task Duedate : " + task.getDueDate() + " " +
                        "Task status : " + taskStatus + " " +
                        "Project : " + task.getProject());
            }
        }
    }

    /**
     * @return The number of tasks to be done.
     */
    private static int getSizeOfTasksToBeDone(List<Task> readTaskList) {
        int tasksToBeDoneSize = 0;

        if (readTaskList.size() != 0) {
            List<Task> tasksToBeDone = readTaskList.stream()
                    .filter(c -> c.getStatus() == false)
                    .collect(Collectors.toList());
            tasksToBeDoneSize = tasksToBeDone.size();
            return tasksToBeDoneSize;
        }
        return tasksToBeDoneSize;
    }

    /**
     * @return The number of tasks marked as done.
     */
    private static int getSizeOfTasksDone(List<Task> readTaskList) {
        int tasksDoneSize = 0;

        if (readTaskList.size() != 0) {
            List<Task> tasksDone = readTaskList.stream()
                    .filter(c -> c.getStatus() == true)
                    .collect(Collectors.toList());
            tasksDoneSize = tasksDone.size();
            return tasksDoneSize;
        }
        return tasksDoneSize;
    }

}
