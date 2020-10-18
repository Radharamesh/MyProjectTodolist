package ProjTodolist;


import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;

public class MainMenu {
    private static ArrayList<Task> TaskList = new ArrayList<>();
    private static boolean quit = false;

    public static void main(String[] args) throws Exception {
        int option;
        int tasksToBeDoneSize;
        int tasksDoneSize;
        Parser parser = new Parser();
        while (quit == false) {
            tasksDoneSize = getSizeOfTasksDone();
            tasksToBeDoneSize = getSizeOfTasksToBeDone();
            parser.printWelcome(tasksToBeDoneSize, tasksDoneSize);
            option = parser.getOption();
            processOption(option, parser);
        }
    }

    public static void processOption(int option, Parser parser) throws Exception {
        String taskTitle;
        String dueDate;
        boolean status;
        String project;

        Boolean addTasks = true;
        switch (option) {
            case 1:
                //showtask
                break;
            case 2:
                //addtask
                while (addTasks == true) {

                    taskTitle = parser.getTaskTitle();
                    dueDate = parser.getTaskDuedate();
                    status = parser.getTaskStatus();
                    project = parser.getTaskProject();

                    Task ts = new Task(taskTitle, dueDate, status, project);
                    TaskList.add(ts);
                    System.out.println("Task added");
                    addTasks = parser.addAnotherTask();
                }


                break;
            case 3:
                //editTask();

                break;
            case 4:
                if (TaskList.size() != 0) {
                    FileHandler writeFileHandler = new FileHandler();
                    //object stream
                    writeFileHandler.writeAsObject(TaskList);
                }

                //saveAndQuit();
                quit = true;
                break;
            default:
                System.out.println("Invalid option");

        }

    }

    private static int getSizeOfTasksToBeDone() {
        int tasksToBeDoneSize = 0;

        FileHandler readFileHandlerToBeDone = new FileHandler();
        List<Task> readTaskListToBeDone = readFileHandlerToBeDone.readAsObject();

        if (readTaskListToBeDone.size() != 0) {
            List<Task> tasksToBeDone = readTaskListToBeDone.stream()
                    .filter(c -> c.getStatus() == false)
                    .collect(Collectors.toList());
            tasksToBeDoneSize = tasksToBeDone.size();
            return tasksToBeDoneSize;
        }
        return tasksToBeDoneSize;
    }

    private static int getSizeOfTasksDone() {
        int tasksDoneSize = 0;
        FileHandler readFileHandlerDone = new FileHandler();
        List<Task> readTaskListDone = readFileHandlerDone.readAsObject();

        if (readTaskListDone.size() != 0) {
            List<Task> tasksDone = readTaskListDone.stream()
                    .filter(c -> c.getStatus() == true)
                    .collect(Collectors.toList());
            tasksDoneSize = tasksDone.size();
            return tasksDoneSize;
        }
        return tasksDoneSize;
    }

}
