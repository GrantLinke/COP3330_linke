import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(IllegalArgumentException.class, ()->{TaskItem task =
                new TaskItem("2019-05-28", "title", "desc", false);});
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(IllegalArgumentException.class, ()-> {TaskItem task =
                new TaskItem("2025-12-28", "", "desc", false);});
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(()-> {TaskItem task =
                new TaskItem("2025-12-28", "title", "desc", false);});
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(()-> {TaskItem task =
                new TaskItem("2025-05-28", "title", "desc", false);});
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem t = new TaskItem();
        LocalDate date = LocalDate.parse("2019-05-28");
        assertThrows(IllegalArgumentException.class, ()-> {t.setDueDateVar(date);});
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem t = new TaskItem();
        LocalDate date = LocalDate.parse("2025-05-28");
        assertDoesNotThrow(()-> {t.setDueDateVar(date);});
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem t = new TaskItem();
        assertThrows(IllegalArgumentException.class, ()->{t.setTitleVar("");});
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem t = new TaskItem();
        assertDoesNotThrow(()->{t.setTitleVar("Valid title");});
    }

}