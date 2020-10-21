package ProjTodolist;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * This class is part of the todolist project.
 * This class handles file operations write and read.
 * When user save tasks, this class saves tasks from list to a text file.
 * while opening application it reads tasks from file and returns list of tasks in Arraylist.
 * */
public class FileHandler {
    private String fileName = "/Users/radhas/Desktop/Project/task.txt";

    /**
     * Creates a new file in the given path and writes the tasks as objects from Arraylist of Task objects.
     */
    public void writeAsObject(ArrayList<Task> list) {

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        }

    }

    /**
     * Reads objects from text file and store it in an arraylist
     * @return Arraylist of tasks from text file.
     */
    public ArrayList<Task> readAsObject() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);

            list = (ArrayList<Task>) stream.readObject();

            stream.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Object not found in file " + e);
        }
        return list;
    }

    /**
     * @return boolean value true if the file in the mentioned path exists, else returns false
     */
    public boolean fileExists() {
        boolean exist = false;
        try {
            File file = new File("/Users/radhas/Desktop/Project/task.txt");
            exist = file.exists();

        } catch (NullPointerException e) {
            System.out.println("File doesn't found " + e);
        }
        return exist;
    }


}