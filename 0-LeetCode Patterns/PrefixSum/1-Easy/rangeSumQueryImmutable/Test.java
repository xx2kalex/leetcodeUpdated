public class Test
{
  private static boolean test1(NumArray na)
  {
    if (na.sumRange(0,2) != 1)
    {
      return false;
    }
    if (na.sumRange(2,5) != -1)
    {
      return false;
    }
    if (na.sumRange(0,5) != -3)
    {
      return false;
    }

    return true;
  }

  public static void main(String[] args)
  {
    int[] nums = {-2,0,3,-5,2,-1};
    NumArray na = new NumArray(nums);
    System.out.println("Test 1: " + test1(na));
  }
}
