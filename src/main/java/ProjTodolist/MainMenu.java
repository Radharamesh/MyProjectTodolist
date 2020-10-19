package ProjTodolist;


import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;

public class MainMenu {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static List<Task> readTaskList;
    private static boolean quit = false;
    private static boolean addTasks = true;

    public static void main(String[] args) throws Exception {
        int option;
        int tasksToBeDoneSize = 0;
        int tasksDoneSize = 0;

        Parser parser = new Parser();

        FileHandler readFileHandler = new FileHandler();
        if (readFileHandler.fileExists() == true) {
            readTaskList = readFileHandler.readAsObject();
            taskList = readFileHandler.readAsObject();
        }
        while (quit == false) {
            tasksDoneSize = getSizeOfTasksDone(taskList);
            tasksToBeDoneSize = getSizeOfTasksToBeDone(taskList);
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

        switch (option) {
            case 1:
                //showtask
                showTaskListByProj();
                showTaskListByDate();

                break;
            case 2:
                //addtask
                while (addTasks == true) {

                    taskTitle = parser.getTaskTitle();
                    dueDate = parser.getTaskDuedate();
                    status = parser.getTaskStatus();
                    project = parser.getTaskProject();

                    Task ts = new Task(taskTitle, dueDate, status, project);
                    taskList.add(ts);
                    System.out.println("Task added");
                    addTasks = parser.addAnotherTask();
                }
                break;
            case 3:
                //editTask();
                int editOption;
                String taskTitleToEdit;
                String taskTitleToUpdate;
                String taskTitleToRemove;
                boolean taskStatusToUpdate = false;
                int taskFieldToEdit;
                editOption = parser.updateOrRemoveTask();

                switch (editOption) {
                    case 1:
                        //Update
                        taskTitleToEdit = parser.getTaskTitleToEdit();
                        //print task detail for this task title
                        taskFieldToEdit = parser.taskFieldToEdit();
                        if (taskFieldToEdit == 1) {
                            taskTitleToUpdate = parser.getTaskTitleToUpdate();
                            for (Task task : taskList) {
                                if (task != null && taskTitleToEdit.equals(task.getTaskTitle())) {
                                    task.setTaskTitle(taskTitleToUpdate);
                                    break;
                                }
                            }
                        } else {
                            taskStatusToUpdate = parser.getTaskStatusToUpdate();
                            for (Task task : taskList) {
                                if (task != null && taskTitleToEdit.equals(task.getTaskTitle())) {
                                    task.setStatus(taskStatusToUpdate);
                                    break;
                                }
                            }
                        }
                        System.out.printf("Task %s updated", taskTitleToEdit);
                        break;
                    case 2:
                        //Remove
                        taskTitleToRemove = parser.getTaskTitleToRemove();
                        for (Task task : taskList) {
                            if (task != null && taskTitleToRemove.equals(task.getTaskTitle())) {
                                taskList.remove(task);
                                break;
                            }
                        }
                        System.out.printf("Task %s removed", taskTitleToRemove);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                break;
            case 4:
                if (taskList.size() != 0) {
                    FileHandler writeFileHandler = new FileHandler();
                    //object stream
                    writeFileHandler.writeAsObject(taskList);
                }

                //saveAndQuit();
                quit = true;
                break;
            default:
                System.out.println("Invalid option");

        }

    }

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
