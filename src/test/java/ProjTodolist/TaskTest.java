package ProjTodolist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTaskTitle() throws Exception {
        Task t = new Task("Addfeature","2020-10-10",false,"Bankingsystem");
        assertEquals("Addfeature", t.getTaskTitle());
    }
    @Test
    void setTaskTitle() {
    }

    @Test
    void getDueDate() {
    }

    @Test
    void setDueDate() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void getProject() {
    }

    @Test
    void setProject() {
    }
}