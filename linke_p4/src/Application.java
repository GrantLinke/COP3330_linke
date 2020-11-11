import java.util.Scanner;

public class Application
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        displayMMPrompt();
    }

    private static void displayMMPrompt()
    {
        System.out.println("Main menu%n+---+---+---+%n");
        System.out.println("1) Create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        userInputMM();
    }

    private static void userInputMM()
    {
        int userIn = 0;
        userIn = input.nextInt();
        if (userIn >= 1 && userIn <= 3)
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

    private static void mmNavigator(int userIn)
    {
        switch(userIn)
        {
            case 1:
                System.out.println("New task list has been created");
                listOperationMenuPrompt();
                break;
            case 2:
                System.out.print("Enter the filename to load: ");
                loadFile();
                break;
            case 3:
                break;
        }
    }
}
