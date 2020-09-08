//Grant Linke COP3330 Fall2020
public class Encrypter
{
    public String encrypt(String input)
    {
        // declarations
        int[] nums = new int[input.length()];
        String result = "";

        // initialize
        nums = stringToInt(input);

        // method calling
        newDigits(nums, input.length());
        swapDigits(nums);

        result = intToString(nums);
        return result;
    }

    public int[] stringToInt(String input)
    {
        int[] nums = new int[input.length()];
        int n = input.length();

        for (int i = 0; i < n; i++)
        {
            nums[i] = Integer.parseInt(input.substring(i, i+1));
        }// end for
        return nums;
    }// end stringToInt

    public void newDigits(int[] nums, int n)
    {
        for (int i = 0; i < n; i++)
        {
            nums[i] = (nums[i] + 7) % 10;
        }// end for
    }//end newDigits

    public void swapDigits(int[] nums)
    {
        int temp;

        temp = nums[3];
        nums[3] = nums[1];
        nums[1] = temp;

        temp = nums[2];
        nums[2] = nums[0];
        nums[0] = temp;
    }// end swapDigits

    public String intToString(int[] nums)
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 4; i++)
        {
            result.append(nums[i]);
        }
        return result.toString();
    }// end intToString
}
