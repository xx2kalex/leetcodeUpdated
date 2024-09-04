import java.util.Arrays;

class Solution
{
  public static int removeElement(int[] nums, int val)
  {
    if (nums.length == 0)
    {
      return 0;
    }

    int placeholder;
    int k = nums.length - 1;
    int startOverPoint = 0;
    int amtOfIllegalInt = amtOfAnInt(nums, val);
    int legalVals = nums.length - amtOfIllegalInt;
    int illegalValsFound = 0;

    // Edge Case: there are no legal values
    if (legalVals == 0)
    {
      return 0;
    }

    for (startOverPoint = 0; startOverPoint < nums.length; startOverPoint++)
    {
      if (illegalValsFound == amtOfIllegalInt)
      {
        return legalVals;
      }

      // Edge Case: the illegal value is the first value
      if (startOverPoint == 0 && nums[startOverPoint] == val)
      {
        if (nums.length == 1)
        {
          return k;
        }
        else
        {
          // Swap last and first values;
          placeholder = nums[startOverPoint];
          for (int j = 1; j < nums.length; j++)
          {
            nums[j - 1] = nums[j];
          }
          nums[k] = placeholder;
        }

        startOverPoint = startOverPoint - 1;
        illegalValsFound++;
        continue;
      }

      // Assigns the illegal value to the end of the list and shifts everything else left
      if ((nums[startOverPoint] == val) && (startOverPoint != 0))
      {
        placeholder = nums[startOverPoint];
        for (int j = startOverPoint + 1; j < nums.length; j++)
        {
          nums[j - 1] = nums[j];
        }
        nums[k] = placeholder;

        startOverPoint = startOverPoint - 1;
        illegalValsFound++;
        continue;
      }
    }

    return legalVals;
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


  public static void main(String[] args)
  {
    int[] nums = {4,5};
    int val = 4;
    System.out.println(removeElement(nums, val));
    System.out.println("Final ans: " + Arrays.toString(nums));
  }
}

