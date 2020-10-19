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
                FileHandler readFileHandler = new FileHandler();
                List<Task> showTaskList = readFileHandler.readAsObject();

                System.out.println("Task list by project");
                List<Task> sortListByProj = showTaskList.stream()
                        .sorted(Comparator.comparing(Task::getProject))
                        .collect(Collectors.toList());

                for(Task task : sortListByProj) {
                    if(task != null) {
                        String taskStatus = task.getStatus() ? "Done" : "Tobedone";
                        System.out.println("Task Title : " + task.getTaskTitle() + " " +
                                "Task Duedate : " + task.getDueDate() + " " +
                                "Task status : " + taskStatus + " " +
                                "Project : " + task.getProject());
                    }
                }

                System.out.println("Task list by date");
                List<Task> sortListByDate = showTaskList.stream()
                        .sorted(Comparator.comparing(Task::getDueDate))
                        .collect(Collectors.toList());

                for(Task task : sortListByDate) {
                    if(task != null) {
                        String taskStatus = task.getStatus() ? "Done" : "Tobedone";
                        System.out.println("Task Title : " + task.getTaskTitle() + " " +
                                "Task Duedate : " + task.getDueDate() + " " +
                                "Task status : " + taskStatus + " " +
                                "Project : " + task.getProject());
                    }
                }
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
                        FileHandler editFileHandler = new FileHandler();
                        ArrayList<Task> editTaskList = editFileHandler.readAsObject();
                        taskTitleToEdit = parser.getTaskTitleToEdit();
                        //print task detail for this task title
                        taskFieldToEdit = parser.taskFieldToEdit();
                        if(taskFieldToEdit == 1) {
                            taskTitleToUpdate = parser.getTaskTitleToUpdate();
                            for(Task task : editTaskList) {
                                if(task != null && taskTitleToEdit.equals(task.getTaskTitle())) {
                                    task.setTaskTitle(taskTitleToUpdate);
                                    break;
                                }
                            }
                        }
                        else {
                            taskStatusToUpdate = parser.getTaskStatusToUpdate();
                            for(Task task : editTaskList) {
                                if(task != null && taskTitleToEdit.equals(task.getTaskTitle())) {
                                    task.setStatus(taskStatusToUpdate);
                                    break;
                                }
                            }
                        }
                        if (editTaskList.size() != 0) {
                            editFileHandler.updateAsObject(editTaskList);
                            System.out.printf("Task %s updated", taskTitleToEdit);
                        }
                        break;
                    case 2:
                        //Remove
                        FileHandler removeFileHandler = new FileHandler();
                        ArrayList<Task> removeTaskList = removeFileHandler.readAsObject();
                        taskTitleToRemove = parser.getTaskTitleToRemove();
                        for(Task task : removeTaskList) {
                            if(task != null && taskTitleToRemove.equals(task.getTaskTitle())) {
                                removeTaskList.remove(task);
                                break;
                            }
                        }
                        if (removeTaskList.size() != 0) {
                            removeFileHandler.updateAsObject(removeTaskList);
                            System.out.println("Task%s removed" + taskTitleToRemove);
                        }
                        break;
                    default:
                        System.out.println("Invalid option");
                }

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
