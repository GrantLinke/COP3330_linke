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
                System.out.print("Enter the filename to load: ");
                loadFile();
                break;
            case 3:
                TaskApp.displayFirstPrompt();
                break;
        }
    }

    private void loadFile()
    {

    }

    private void contactMenuPrompt(ContactList contactList)
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
                //removeItemDisplay();
                break;
            case 5:
                //saveListPrompt(contactList);
                break;
            case 6:
                System.out.println("Returning to main menu.");
                displayInitialPrompt();
        }
        contactMenuPrompt(contactList);
    }

    private void editItemPrompt(ContactList contactList) {
        contactList.viewList();
        System.out.println("");
        System.out.print("Which contact will you edit: ");
        try {
        int userIn = input.nextInt();
        editItem(contactList, userIn);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid number entered.");
        }
    }

    private void editItem(ContactList contactList, int index)
    {
        ContactItem c = new ContactItem();
        if (index > contactList.contactList.size())
        {
            throw new IndexOutOfBoundsException();
        }
        c = contactList.contactList.get(index);

        System.out.print("Please enter new first name: ");
        getFirstName(c);

        System.out.print("Please enter new last name: ");
        getLastName(c);

        System.out.print("Please enter new phone number: ");
        getPhoneNum(c);

        System.out.print("Please enter new email address: ");
        getEmail(c);
    }

    private static void addItem(ContactList contactList)
    {
        ContactItem c = new ContactItem();

        System.out.print("Please enter first name: ");
        getFirstName(c);

        System.out.print("Please enter last name: ");
        getLastName(c);

        System.out.print("Please enter phone number: ");
        getPhoneNum(c);

        System.out.print("Please enter email address: ");
        getEmail(c);

        contactList.contactList.add(c);
    }

    private static void getFirstName(ContactItem c){
        String userIn;
        while(true) {
            try {
                userIn = input.nextLine();
                userIn = input.nextLine();
                c.setFName(userIn);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    private static void getLastName(ContactItem c){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                c.setLName(userIn);
                break;
            }catch(IllegalArgumentException e){
                System.out.println();
            }
        }
    }

    private static void getPhoneNum(ContactItem c){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                c.setPhoneNum(userIn);
                break;
            }catch(IllegalArgumentException e){
                System.out.println();
            }
        }
    }

    private static void getEmail(ContactItem c){
        String userIn;
        while(true){
            try{
                userIn = input.nextLine();
                c.setEmail(userIn);
                break;
            }catch(IllegalArgumentException e){
                System.out.println();
            }
        }
    }

}

