import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

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
                System.out.println(i + ") " + contactList.get(i).toString());
            }
        }
    }

    public void removeItem(int userIn) {
        contactList.remove(userIn);
    }

    public void save(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            output.format("contacts%n");
            for(int i = 0; i < contactList.size(); i++)
            {
                ContactItem c = contactList.get(i);
                output.format("%s%n", c.getFName());
                output.format("%s%n", c.getLName());
                output.format("%s%n", c.getPhoneNum());
                output.format("%s%n", c.getEmail());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadFile(String fileName) {
        try(Scanner fileIn = new Scanner(Paths.get(fileName))){
            String fileHead = fileIn.nextLine();
            if(fileHead.equalsIgnoreCase("contacts"))
            {
                while(fileIn.hasNext())
                {
                    String fName = fileIn.nextLine();
                    String lName = fileIn.nextLine();
                    String phoneNum = fileIn.nextLine();
                    String email = fileIn.nextLine();

                    ContactItem c = new ContactItem(fName, lName, phoneNum, email);
                    this.contactList.add(c);
                }
            }
        }catch (IOException e){
            System.out.println("Filename not found.");
        }
    }

    public void addItem(String fName, String lName, String phoneNum, String email) {
        if (fName.length() < 1
                && lName.length() < 1
                && email.length() < 1
                && phoneNum.length() < 1) {
            throw new IllegalArgumentException();
        }
        ContactItem c = new ContactItem(fName, lName, phoneNum, email);
        contactList.add(c);
    }
}
