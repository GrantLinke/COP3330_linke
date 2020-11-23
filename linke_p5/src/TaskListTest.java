import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem t = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t);
        assertEquals(taskList.taskList.size(), 1);
    }

    @Test public void completingTaskItemChangesStatus(){
        TaskItem t = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t);
        assertFalse(taskList.taskList.get(0).getCompleted());
        taskList.markItem(0, true);
        assertTrue(taskList.taskList.get(0).getCompleted());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t);
        assertThrows(IndexOutOfBoundsException.class, ()->{taskList.markItem(20, true);});
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2034-05-28", "new title", "new Description", true);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        taskList.editItem(t2, 0);
        assertEquals(t1.getDesc(), t2.getDesc());
        assertEquals(t1.getTitle(), t2.getTitle());
        assertEquals(t1.getDueDate(), t2.getDueDate());
        assertEquals(t1.getCompleted(), t2.getCompleted());
        assertNotEquals(t1Dupe.getTitle(), t1.getTitle());
        assertNotEquals(t1Dupe.getDesc(), t2.getDesc());
        assertNotEquals(t1Dupe.getDueDate(), t2.getDueDate());
        assertNotEquals(t1Dupe.getCompleted(), t2.getCompleted());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2025-05-28", "Title", "new Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        taskList.editItem(t2, 0);
        assertEquals(t1.getDesc(), t2.getDesc());
        assertNotEquals(t1Dupe.getDesc(), t2.getDesc());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2025-05-28", "Title", "new Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()->{taskList.editItem(t2, 20);});
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2032-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        taskList.editItem(t2, 0);
        assertEquals(t1.getDueDate(), t2.getDueDate());
        assertNotEquals(t1Dupe.getDueDate(), t2.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2032-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> {taskList.editItem(t1, 20);});
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2025-05-28", "new Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        taskList.editItem(t2, 0);
        assertEquals(t1.getTitle(), t2.getTitle());
        assertNotEquals(t1Dupe.getTitle(), t2.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t1Dupe = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2025-05-28", "new Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> {taskList.editItem(t1, 20);});
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> {taskList.taskList.get(20).getDesc();});
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertEquals(taskList.taskList.get(0).getDesc(), "Description");
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> {taskList.taskList.get(20).getDueDate();});
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        LocalDate dueDateProto = LocalDate.parse("2025-05-28");
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertEquals(taskList.taskList.get(0).getDueDate(), dueDateProto);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> {taskList.taskList.get(20).getTitle();});
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        taskList.addItem(t1);
        assertEquals(taskList.taskList.get(0).getTitle(), "Title");
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList t = new TaskList();
        assertTrue(t.taskList.isEmpty());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskItem t2 = new TaskItem("2025-05-28", "new Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        taskList.addItem(t2);
        assertEquals(taskList.taskList.size(), 2);
        taskList.removeItem(0);
        assertEquals(taskList.taskList.size(), 1);
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem t1 = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t1);
        assertThrows(IndexOutOfBoundsException.class, ()-> taskList.removeItem(20));
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        //RIP
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem t = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t);
        assertFalse(taskList.taskList.get(0).getCompleted());
        taskList.markItem(0, false);
        assertFalse(taskList.taskList.get(0).getCompleted());
    }
    @Test
    public void  uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("2025-05-28", "Title", "Description", false);
        TaskList taskList = new TaskList();
        taskList.addItem(t);
        assertThrows(IndexOutOfBoundsException.class, ()->{taskList.markItem(20, false);});
    }

}