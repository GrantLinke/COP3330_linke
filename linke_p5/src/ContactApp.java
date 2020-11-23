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

    private boolean lomInputValid(int userIn)
    {
        return userIn >= 1 && userIn <= 8;
    }

    private void mmNavigator(int userIn)
    {
        switch(userIn)
        {
            case 1:
                ContactList contactList = new ContactList();
                System.out.println("New task list has been created.");
                contactMenuPrompt(contactList);
                break;
            case 2:
                System.out.print("Enter the filename to load: ");
                loadFile();
                break;
            case 3:
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

    private static int lomNavigator(int userIn, ContactList contactList)
    {
        switch(userIn)
        {
            case 1:
                contactList.viewList();
                return 1;
            case 2:
                addItem();
                return 2;
            case 3:
                editItemPrompt();
                return 3;
            case 4:
                removeItemDisplay();
                return 4;
            case 5:
                saveListPrompt(contactList);
                return 5;
            case 6:
                System.out.println("Returning to main menu.");
                return 6;
        }
        return 8;
    }

}

