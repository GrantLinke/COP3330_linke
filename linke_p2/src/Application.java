import java.util.ArrayList;
import java.util.Scanner;
public class Application
{
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static double getUserHeight()
    {
        Scanner input = new Scanner(System.in);
        double userIn = 0;

        // get user input
        System.out.print("Please enter height (in inches): ");
        userIn = input.nextDouble();
        input.nextLine();

        // check valid input
        if (validInputHW(userIn))
        {
            return userIn;
        }

        else{
            System.out.println("Invalid input.");
            return getUserHeight();
        }
    }

    public static double getUserWeight()
    {
        Scanner input = new Scanner(System.in);
        double userIn = 0;

        // get user input
        System.out.print("Please enter weight(in pounds): ");
        userIn = input.nextDouble();
        input.nextLine();

        // check valid input
        if (validInputHW(userIn))
        {
            return userIn;
        }

        else{
            System.out.println("Invalid input.");
            return getUserWeight();
        }
    }

    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        double out1 = bmi.calcBMI();
        String out1f, out2 = bmi.bmiCategory();

        // formatting
        out1f = String.format("%.2f", out1);

        System.out.println("BMI is: " + out1f + " user is " + out2 + ".");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        double bmiAvg = 0;
        int counter = 0;
        String formatted;

        // checking for empty array
        if (bmiData.size() == 0)
        {
            System.out.println("Average BMI of all users is: 0.00");
            return;
        }

        // loop thru arraylist to average
        for (int i = 0; i < bmiData.size(); i ++)
        {
            BodyMassIndex bmi = new BodyMassIndex(bmiData.get(i));
            bmiAvg += bmi.getBMI();
            counter++;
        }
        bmiAvg /= counter;
        formatted = String.format("%.2f", bmiAvg);
        System.out.println("Average BMI of all users is: " + formatted);
    }

    public static boolean moreInput()
    {
        if (getUserInput().equalsIgnoreCase("y"))
        {
            return true;
        }

        else{
            return false;
        }
    }

    public static String getUserInput()
    {
        String userIn;
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to enter more data? (Y/N) ");
        userIn = input.nextLine();

        if (validInputLoop(userIn))
        {
            return userIn.toUpperCase();
        }
        else{
            System.out.println("Improper input.");
            return getUserInput().toUpperCase();
        }
    }

    public static boolean validInputLoop(String userIn)
    {
        if (userIn.equalsIgnoreCase("y") || userIn.equalsIgnoreCase("n"))
        {
            return true;
        }

        else{
            return false;
        }
    }

    public static boolean validInputHW(double num)
    {
        if (num > 0)
        {
            return true;
        }

        else{
            return false;
        }
    }
}
