import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TaskList
{
    protected ArrayList<TaskItem> taskList = new ArrayList<>();
    private int taskCounter = 0;
    private Scanner input = new Scanner(System.in);

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

    public void addItem(TaskItem t)
    {
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

    public void editItem(TaskItem taskItem, int index)
    {
        if (index > taskList.size() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        TaskItem t = taskList.get(index);
        t.title = taskItem.title;
        t.dueDate = taskItem.dueDate;
        t.desc = taskItem.desc;
        t.completed = taskItem.completed;
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

    public void removeItem(int userIn)
    {
        taskList.remove(userIn);
    }

    public void removeItemDisplay()
    {
        int userIn;
        if (validCount()) {
            while (true) {
                try {
                    viewList();
                    System.out.println("Which task will you remove?");
                    userIn = input.nextInt();
                    if (userIn > taskCounter - 1 || userIn < 0)
                    {
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid input. Please try again.");
                }
            }
            removeItem(userIn);
        }
        else{removeItem(-1);}
    }

    public void markItem(int userIn, boolean b)
    {
        if (userIn > taskList.size() || userIn < 0){
            throw new IndexOutOfBoundsException();
        }
        TaskItem t = taskList.get(userIn);
        t.setCompleted(b);
    }

    public void markItemDisplay(boolean b) {
        int userIn;
        String prompt;

        prompt = b ? "completed" : "not completed";
        if (validCount()) {
            while (true) {
                try {
                    viewList();
                    System.out.println("Which task will you mark as " + prompt + "?");
                    userIn = input.nextInt();
                    if (userIn > taskCounter - 1 || userIn < 0)
                    {
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid input. Please try again.");
                }
            }
            markItem(userIn, b);
        }
    }

    public void saveList(String userIn)
    {
        String boolVal;
        try(Formatter f = new Formatter(userIn)){
            for (int i = 0; i < taskList.size(); i++){
                TaskItem t = taskList.get(i);
                f.format("%s;%s;%s;%b%n", t.getDueDate(), t.getTitle(), t.getDesc(), t.getCompleted());
            }
            System.out.println("Successfully created the file!");
        }catch (FileNotFoundException e){
            System.out.println("Error creating file.");
        }catch (IOException e){
            System.out.println("An error has occurred");
        }
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


    public void loadFile(String userIn) {
        try(Scanner fileRead = new Scanner(Paths.get(userIn))){
            while (fileRead.hasNext()) {
                TaskItem task =
                        new TaskItem(fileRead.next(), fileRead.nextLine(), fileRead.next(), fileRead.nextBoolean());
                taskList.add(task);
            }
        } catch (IOException e) {
            System.out.println("Filename entered does not exist.");
        }catch(NoSuchElementException e){
            System.out.println("Filename does not exist.");
        }
    }
}
