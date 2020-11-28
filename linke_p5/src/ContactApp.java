import java.util.Scanner;

public class ContactApp
{
    private static Scanner input = new Scanner(System.in);
    public void displayInitialPrompt()
    {
        System.out.println("Main menu\n+---+---+---+\n");
        System.out.println("1) Create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        userInputInitial();
    }

    private void userInputInitial()
    {
        int userIn = 0;
        userIn = input.nextInt();
        if (mmInputValid(userIn))
        {
            mmNavigator(userIn);
        }
        else{
            System.out.println("Invalid input. Please try again.");
            displayInitialPrompt();
        }
    }

    private boolean mmInputValid(int userIn)
    {
        return userIn >= 1 && userIn <= 3;
    }

    private static boolean lomInputValid(int userIn)
    {
        return userIn >= 1 && userIn <= 8;
    }

    private void mmNavigator(int userIn)
    {
        switch(userIn)
        {
            case 1:
                ContactList contactList = new ContactList();
                System.out.println("New contact list has been created.");
                contactMenuPrompt(contactList);
                break;
            case 2:
                ContactList contactList2 = new ContactList();
                System.out.print("Enter the filename to load: ");
                loadFile(contactList2);
                break;
            case 3:
                TaskApp.displayFirstPrompt();
                break;
        }
    }

    private void loadFile(ContactList contactList)
    {
        String fileName = input.nextLine();
        fileName = input.nextLine();
        contactList.loadFile(fileName);
    }

    public void contactMenuPrompt(ContactList contactList)
    {
        int userIn = 0;
        while (true) {
            try {

                System.out.println("List Operations Menu\n+---+---+---+---+---+---+\n");
                System.out.println("1) View the list");
                System.out.println("2) Add an item");
                System.out.println("3) Edit an item");
                System.out.println("4) Remove an item");
                System.out.println("5) Save the current list");
                System.out.println("6) Quit to the main menu");
                userInputLOM(contactList);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
            TaskApp.displayFirstPrompt();
        }

    private void userInputLOM(ContactList contactList) {

        int userIn = 0;
        userIn = input.nextInt();
        if (lomInputValid(userIn))
        {
            lomNavigator(userIn, contactList);
        }
        else{
            System.out.println("Invalid input. Please try again.");
            contactMenuPrompt(contactList);
        }
    }

    private void lomNavigator(int userIn, ContactList contactList)
    {
        switch(userIn)
        {
            case 1:
                contactList.viewList();
                break;
            case 2:
                addItem(contactList);
                break;
            case 3:
                editItemPrompt(contactList);
                break;
            case 4:
                removeItemDisplay(contactList);
                break;
            case 5:
                saveListPrompt(contactList);
                break;
            case 6:
                System.out.println("Returning to main menu.");
                displayInitialPrompt();
        }
        contactMenuPrompt(contactList);
    }

    private void saveListPrompt(ContactList contactList) {
        String userIn = "defaultContacts.txt";
        while(true) {
            try {
                System.out.print("Please enter a filename to save as: ");
                userIn = input.nextLine();
                userIn = input.nextLine();
                if (!userIn.contains(".txt")) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please include a file extension (.txt) at the end of your filename.");
            }
        }
        contactList.save(userIn);
    }

    private void removeItemDisplay(ContactList contactList)
    {
        int userIn;
        if (validCount(contactList)) {
            while (true) {
                try {
                    contactList.viewList();
                    System.out.println("Which task will you remove?");
                    userIn = input.nextInt();
                    if (userIn > contactList.contactList.size() - 1 || userIn < 0)
                    {
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid input. Please try again.");
                }
            }
            contactList.removeItem(userIn);
        }
    }

    private boolean validCount(ContactList contactList)
    {
        if (contactList.contactList.size() == 0)
        {
            System.out.println("No current contacts.");
            return false;
        }
        return true;
    }

    private void editItemPrompt(ContactList contactList) {
        if(contactList.contactList.size() <= 0)
        {
            System.out.println("No current contacts.");
            return;
        }

        while(true) {
            contactList.viewList();
            System.out.println("");
            System.out.print("Which contact will you edit: ");
            try {
                int userIn = input.nextInt();
                editItem(contactList, userIn);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid number entered.");
            }
        }
    }

    private void editItem(ContactList contactList, int index)
    {
        ContactItem c = new ContactItem();
        if (index > contactList.contactList.size())
        {
            throw new IndexOutOfBoundsException();
        }
        ContactItem c1 = contactList.contactList.get(index);
        ContactItem c2 = new ContactItem();

        System.out.print("Please enter new first name: ");
        c2.setFName(getFirstName());

        System.out.print("Please enter new last name: ");
        c2.setLName(getLastName());

        System.out.print("Please enter new phone number: ");
        c2.setPhoneNum(getPhoneNum());

        System.out.print("Please enter new email address: ");
        c2.setEmail(getEmail());

        contactList.editItem(c1, c2);
    }

    private static void addItem(ContactList contactList)
    {
        ContactItem c = new ContactItem();

        System.out.print("Please enter first name: ");
        String fName = getFirstName();

        System.out.print("Please enter last name: ");
        String lName = getLastName();

        System.out.print("Please enter phone number: ");
        String phoneNum = getPhoneNum();

        System.out.print("Please enter email address: ");
        String email = getEmail();

        contactList.addItem(fName, lName, phoneNum, email);
    }

    private static String getFirstName(){
        String userIn;
        while(true) {
            try {
                userIn = input.nextLine();
                userIn = input.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid name input. Please try again.");
            }
        }
        return userIn;
    }

    private static String getLastName(){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Invalid name input. Please try again.");
            }
        }
        return userIn;
    }

    private static String getPhoneNum(){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Invalid phone number input. Please try again.");
            }
        }
        return userIn;
    }

    private static String getEmail(){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("Invalid email input. Please try again.");
            }
        }
        return userIn;
    }

}

