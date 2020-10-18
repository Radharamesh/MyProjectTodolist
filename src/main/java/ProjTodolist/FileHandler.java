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


public class FileHandler {
    private String filename = "/Users/radhas/IdeaProjects/MyprojTodolist/src/Taskfile.txt";

    ArrayList<Task> taskList1 = new ArrayList<>();

    //Object Stream
    public void writeAsObject(ArrayList<Task> list) {
        taskList1 = readAsObject();
        if (taskList1.size() > 0) {
            for (int i = 0; i < taskList1.size(); i++) {

                Task t = taskList1.get(i);
                list.add(t);
            }
        }

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream

            output.writeObject(list);

            output.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        }

    }

    public ArrayList<Task> readAsObject() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
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

}