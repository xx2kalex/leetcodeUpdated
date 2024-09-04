import java.util.Arrays;

class Solution
{
  /**
   * Removes duplicates from an array in place such that each unique integer appears only once, for
   * the first n indexes, where n is the amount of unique integers
   *
   * @param nums
   * @return
   */
  public static int removeDuplicates(int[] nums)
  {
    // Immediate return if the array is empty
    if (nums.length == 0)
    {
      return 0;
    }

    int j = 1; // Initializes the index of the first unique integer to be 1
    for (int i = 1; i < nums.length; i++)
    {
      // If we have encountered a non-unique integer
      if (nums[i] != nums[j - 1])
      {
        // Move the current number to the index of the last unique integer
        nums[j] = nums[i];
        j++; // Increment the index of the last unique integer
      }
    }

    // This variable also serves a purpose to show the count of unique integers
    return j;
  }

  public static void main(String args[])
  {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }
}
