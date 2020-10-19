package ProjTodolist;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTaskTitle()  {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        assertEquals("Addfeature", t.getTaskTitle());
    }
    @Test
    void setTaskTitle() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        t.setTaskTitle("Addtaskfeature");
        assertEquals("Addtaskfeature", t.getTaskTitle());
    }

    @Test
    void getDueDate() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        assertEquals("2020-10-10", t.getDueDate().toString());
    }

    @Test
    void setDueDate() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        t.setDueDate(LocalDate.parse("2021-02-19", formatter));
        assertEquals("2021-02-19", t.getDueDate().toString());
    }

    @Test
    void getStatus() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        assertEquals(false, t.getStatus());
    }

    @Test
    void setStatus() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        t.setStatus(true);
        assertEquals(true, t.getStatus());
    }

    @Test
    void getProject() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        assertEquals("Bankingsystem", t.getProject());
    }

    @Test
    void setProject() {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        t.setProject("Todolist");
        assertEquals("Todolist", t.getProject());
    }
}