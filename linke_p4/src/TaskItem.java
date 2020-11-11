import java.util.Date;
public class TaskItem
{
    private String title;
    private String desc;
    private Date dueDate;
    private boolean completed;

    public TaskItem(String title, String desc, Date dueDate, boolean completed)
    {
        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public TaskItem()
    {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDueDate(Date dueDate) {
        Date today = new Date();
        today.setHours(0);
        if (today.before(dueDate) || dueDate.toString().length() < 10)
        {
            throw new IllegalArgumentException("Warning: Invalid date entered.");
        }
        this.dueDate = dueDate;
    }
}
