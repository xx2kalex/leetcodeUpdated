import java.util.Arrays;

public class BestSolution
{
  public static int removeElement(int[] nums, int val)
  {
    int indexPrevLegalInt = 0;

    for (int i = 0; i < nums.length; i++)
    {
      if (nums[i] != val)
      {
        nums[indexPrevLegalInt] = nums[i];
        indexPrevLegalInt++;
      }
    }

    return indexPrevLegalInt;
  }

  public static void main(String[] args)
  {
    int[] nums = {0,1,2,2,3,0,4,2};
    int val = 2;
    System.out.println(removeElement(nums, val));
    System.out.println("Final ans: " + Arrays.toString(nums));
  }

}
