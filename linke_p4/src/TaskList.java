import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskList extends TaskItem
{
    private ArrayList<TaskItem> taskList = new ArrayList<>();
    private int taskCounter = 0;
    public void viewList()
    {
        System.out.println("Current tasks\n+---+---+---+");
        if (taskList.isEmpty())
        {
            System.out.println("\n");
        }
        else{
            for (int i = 0; i < taskList.size(); i++)
            {
                System.out.println(i + ") " + taskList.get(i).toStringDisplay());
            }
        }
    }

    public void addItem()
    {
        TaskItem t = new TaskItem();
        t.setTitle();
        t.setDesc();
        t.setDueDate();
        taskList.add(t);
        this.taskCounter++;
        System.out.println("Task has been successfully added to Task List!");
    }

    public void editItem()
    {
        String userIn;
        TaskItem t = editItemDisplay();
        t.setTitle();
        t.setDesc();
        t.setDueDate();
    }

    public TaskItem editItemDisplay() {
        TaskItem t;
        while (true) {
            try {
                if (validCount()) {
                    viewList();
                    System.out.print("Which task will you edit? ");
                    t = editItemInput();
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return t;
    }

    public TaskItem editItemInput()
    {
        int userIn = input.nextInt();
        if (userIn > taskCounter - 1)
        {
            throw new IllegalArgumentException();
        }
        return this.taskList.get(userIn);
    }

    public void removeItem()
    {
        if (validCount()) {
            viewList();
            System.out.println("Which task will you remove?");
        }
    }

    public void markItem(boolean b)
    {

    }

    public void saveList()
    {

    }

    public boolean validCount()
    {
        if (taskCounter == 0)
        {
            System.out.println("No current tasks.");
            return false;
        }
        return true;
    }
}
