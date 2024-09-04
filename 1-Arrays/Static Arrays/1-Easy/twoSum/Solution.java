import java.util.Arrays; // External library used only for testing

class Solution
{
  /**
   * Finds the indices of two numbers from a given array that add up to a specific target
   * @param nums - the array of numbers
   * @param target - the target sum
   * @return - an array of indices whose numbers add up to the target
   */
  public static int[] twoSum(int[] nums, int target)
  {
    int[] answerArray = new int[2];
    for (int i = 0; i < nums.length; i++)
    {
      for (int j = 0; j < nums.length; j++)
      {
        // If you have the same index adding up to your target, we move on to the next index
        if (i == j && target == nums[i] + nums[j])
        {
          continue;
        }

        // Do the numbers at these two indices add up to the target
        if (nums[i] + nums[j] == target)
        {
          // If-else logic to sort the array by lowest index
          if (i < j)
          {
            answerArray[0] = i;
            answerArray[1] = j;
          }
          else
          {
            answerArray[1] = i;
            answerArray[0] = j;
          }
        }
      }
    }

    return answerArray;
  }

  /**
   * Main method for testing
   * @param args
   */
  public static void main(String args[])
  {
    System.out.println(Arrays.toString(twoSum(new int[] {5, 5}, 10)));
  }
}
