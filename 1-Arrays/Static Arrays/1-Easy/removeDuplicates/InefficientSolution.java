class InefficientSolution
{
  /**
   * Removes duplicates from an array in place such that each unique element appears only once
   *
   * @param nums - the array of numbers
   * @return - the number of unique elements in nums
   */
  public static int removeDuplicates(int[] nums)
  {
    int amtOfThisInt; // keeps track of how many occurrences there are of each integer value
    int finalNum = nums[nums.length - 1]; // the final (and largest) number in the array
    int uniqueNumbers = 0; // counts how many unique integers exist in the array
    boolean finalNumAccessed = false; // has the final integer in the array been accessed

    // iterates through the original array, removing duplicate values as needed
    for (int i = 1; i < nums.length; i++)
    {
      amtOfThisInt = amtOfAnInt(nums, nums[i]);
      while (amtOfThisInt > 1)
      {
        removeValue(nums, i);
        amtOfThisInt--;
      }
    }

    // iterates through the amended array
    for (int i = 0; i < nums.length; i++)
    {
      // increments the number of unique elements
      if (amtOfAnInt(nums, nums[i]) == 1)
      {
        uniqueNumbers++;
      }

      // only increments uniqueNumbers the first time we come across finalNum
      if (!finalNumAccessed)
      {
        if (nums[i] == finalNum)
        {
          uniqueNumbers++;
          finalNumAccessed = true;
        }
      }

    }

    return uniqueNumbers;
  }

  /**
   * Removes the value at a specified index from the array
   * @param arr - the input array
   * @param indexToDelete - the index from which we need to delete
   */
  private static void removeValue(int[] arr, int indexToDelete)
  {
    // iterates through the array and shifts everything left from where we are deleting
    for (int i = indexToDelete + 1; i < arr.length; i++)
    {
      arr[i - 1] = arr[i];
    }
  }

  /**
   * Helper method to determine the amount of occurrences of a specific integer in a given array
   *
   * @param nums - the array of numbers
   * @param num  - the particular integer
   * @return - the number of occurrences of a particular integer
   */
  private static int amtOfAnInt(int[] nums, int num)
  {
    int numMatches = 0;
    for (int i = 0; i < nums.length; i++)
    {
      int currInt = nums[i];

      if (currInt == num)
      {
        numMatches++;
      }
    }

    return numMatches;
  }

  public static void main(String args[])
  {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    System.out.println(removeDuplicates(nums));
  }
}
