package ProjTodolist;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void getOption() {
        String option = "2";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        Scanner sc = new Scanner(System.in);
        String actualInput = sc.nextLine();
        assertEquals(option,actualInput);
    }

    @Test
    void addAnotherTask() {
        String option = "Y";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        Scanner sc = new Scanner(System.in);
        String actualInput = sc.nextLine();
        assertEquals(option,actualInput);
    }

    @Test
    void updateOrRemoveTask() {
    }

    @Test
    void taskFieldToEdit() {
    }

    @Test
    void getTaskTitleToUpdate() {
    }

    @Test
    void getTaskStatusToUpdate() {
    }

    @Test
    void getTaskTitleToEdit() {
    }

    @Test
    void getTaskTitleToRemove() {
    }

    @Test
    void getTaskTitle() {
    }

    @Test
    void getTaskDuedate() {
    }

    @Test
    void getTaskStatus() {
    }

    @Test
    void getTaskProject() {
    }
}