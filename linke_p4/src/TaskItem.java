import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskItem
{
    private String title;
    private String desc;
    private LocalDate dueDate;
    private boolean completed = false;
    protected Scanner input = new Scanner(System.in);

    public TaskItem(String title, String desc, LocalDate dueDate, boolean completed)
    {
        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;
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

    public void setDesc() {
        String desc;
        System.out.print("(Optional) Please enter a description for the task: ");
        desc = input.nextLine();
        this.desc = desc;
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
}
