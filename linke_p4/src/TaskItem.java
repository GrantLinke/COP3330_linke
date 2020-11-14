import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskItem
{
    protected String title;
    protected String desc = " ";
    protected LocalDate dueDate;
    protected boolean completed = false;
    protected Scanner input = new Scanner(System.in);

    public TaskItem(String dueDate, String title, String desc, boolean completed)
    {
        setTitleVar(title);
        this.desc = desc;
        LocalDate date = LocalDate.parse(dueDate);
        setDueDateVar(date);
        this.completed = completed;
    }

    public TaskItem()
    {

    }

    public void setTitle() {
        String title;
        while (true) {
            try {
                System.out.print("Please enter a title for the task: ");
                title = input.nextLine();
                if (title.length() < 1){
                    throw new InputMismatchException();
                }
                this.title = title;
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Warning: Invalid input. Please try again.");
            }catch(InputMismatchException e){
                System.out.println("Warning: Invalid input. Please try again.");
            }
        }
        this.title = title;
    }

    public void setDescVar(String desc) {
        this.desc = desc;
    }

    public void setDueDateVar(LocalDate dueDate){
        LocalDate today = java.time.LocalDate.now();
            if (today.isAfter(dueDate)){
                throw new IllegalArgumentException();
            }
        this.dueDate = dueDate;
    }

    public void setTitleVar(String title){
        if (title.length() < 1)
        {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    protected void setCompleted(boolean b) {
        this.completed = b;
    }

    public void setDesc(){
        System.out.print("(Optional) Please enter a description for the task: ");
        setDescVar(input.nextLine());
    }

    public void setDueDate() {
        String userIn;
        LocalDate today = java.time.LocalDate.now();
        while (true) {
            try {
                System.out.print("Please enter a due date [YYYY-MM-DD]: ");
                userIn = input.nextLine();
                LocalDate dueDate = LocalDate.parse(userIn);
                if (today.isAfter(dueDate) || userIn.length() < 10) {
                    throw new IllegalArgumentException("Warning: Invalid date entered.");
                }
                this.dueDate = dueDate;
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Invalid data. Please try again.");
            }
        }
    }

    public String toStringDisplay()
    {
        if (!completed) {
            return "[" + dueDate.toString() + "] " + this.title + ": " + this.desc;
        }

        else{
            return "*** [" + dueDate.toString() + "] " + this.title + ": " + this.desc;
        }
    }

    @Override
    public String toString()
    {
        return dueDate.toString() + " " + this.title + " " + this.desc;
    }

    protected boolean getCompleted()
    {
        return this.completed;
    }

    protected String getTitle()
    {
        return this.title;
    }

    protected String getDesc()
    {
        return this.desc;
    }
    protected LocalDate getDueDate(){
        return this.dueDate;
    }
}
