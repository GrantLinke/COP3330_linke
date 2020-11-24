import java.util.ArrayList;
import java.util.List;

public class ContactList
{
    List<ContactItem> contactList = new ArrayList<ContactItem>();

    public void viewList() {
        System.out.println("Current contacts\n+---+---+---+");
        if (contactList.isEmpty())
        {
            System.out.println("\n");
        }
        else{
            for (int i = 0; i < contactList.size(); i++)
            {
                System.out.println(i + ") " + contactList.get(i).toStringDisplay());
            }
        }
    }
}
