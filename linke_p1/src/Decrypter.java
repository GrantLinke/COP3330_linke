//Grant Linke COP3330 Fall2020
public class Decrypter
{
    public String decrypt(String input)
    {
        // declarations
        int[] nums = new int[input.length()];
        String result = "";

        // initialize
        nums = stringToInt(input);

        // method calling
        unswapDigits(nums);
        oldDigits(nums, input.length());

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

    public void oldDigits(int[] nums, int n)
    {
        for (int i = 0; i < n; i++)
        {
            if (nums[i] >= 7)
            {
                nums[i] -= 7;
            }
            else
            {
                nums[i] += 3;
            }
        }// end for
    }//end newDigits

    public void unswapDigits(int[] nums)
    {
        int temp;

        temp = nums[1];
        nums[1] = nums[3];
        nums[3] = temp;

        temp = nums[0];
        nums[0] = nums[2];
        nums[2] = temp;
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
