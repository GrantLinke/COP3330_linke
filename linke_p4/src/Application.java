import java.util.Scanner;

public class Application
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        displayMMPrompt();
    }

    private static void displayMMPrompt()
    {
        System.out.println("Main menu\n+---+---+---+\n");
        System.out.println("1) Create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        userInputMM();
    }

    private static void userInputMM()
    {
        int userIn = 0;
        userIn = input.nextInt();
        if (mmInputValid(userIn))
        {
            mmNavigator(userIn);
        }
        else{
            System.out.println("Invalid input. Please try again.");
            displayMMPrompt();
        }
    }

    private static boolean mmInputValid(int userIn)
    {
        return userIn >= 1 && userIn <= 3;
    }

    private static boolean lomInputValid(int userIn)
    {
        return userIn >= 1 && userIn <= 8;
    }

    private static void mmNavigator(int userIn)
    {
        switch(userIn)
        {
            case 1:
                TaskList taskList = new TaskList();
                System.out.println("New task list has been created.");
                listOperationMenuPrompt(taskList);
                break;
            case 2:
                System.out.print("Enter the filename to load: ");
                loadFile();
                break;
            case 3:
                break;
        }
    }

    private static void loadFile()
    {

    }

    private static void listOperationMenuPrompt(TaskList taskList)
    {
        int userIn = 0;
        while(userIn != 8)
        {
            System.out.println("List Operations Menu\n+---+---+---+---+---+---+\n");
            System.out.println("1) View the list");
            System.out.println("2) Add an item");
            System.out.println("3) Edit an item");
            System.out.println("4) Remove an item");
            System.out.println("5) Mark an item as completed");
            System.out.println("6) Unmark an item as completed");
            System.out.println("7) Save the current list");
            System.out.println("8) Quit to the main menu");
            userIn = userInputLOM(taskList);
        }
        displayMMPrompt();
    }

    private static int userInputLOM(TaskList taskList)
    {
        int userIn = 0;
        userIn = input.nextInt();
        if (lomInputValid(userIn))
        {
            return lomNavigator(userIn, taskList);
        }
        else{
            System.out.println("Invalid input. Please try again.");
            listOperationMenuPrompt(taskList);
        }
        return 0;
    }

    private static int lomNavigator(int userIn, TaskList taskList)
    {
        switch(userIn)
        {
            case 1:
                taskList.viewList();
                return 1;
            case 2:
                taskList.addItem();
                return 2;
            case 3:
                taskList.editItem();
                return 3;
            case 4:
                taskList.removeItem();
                return 4;
            case 5:
                taskList.markItem(true);
                return 5;
            case 6:
                taskList.markItem(false);
                return 6;
            case 7:
                taskList.saveList();
                return 7;
            case 8:
                System.out.println("Returning to main menu.");
                return 8;
        }
        return 8;
    }

}
