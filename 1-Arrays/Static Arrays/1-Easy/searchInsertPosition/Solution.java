class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int toReturn = -1;
        if (nums.length == 1 && target > nums[0])
        {
            toReturn = 1;
        }
        else if (nums.length == 1 && target <= nums[0])
        {
            toReturn = 0;
        }
        else
        {
            int i = 0;
            int j = nums.length - 1;

            while (i != j + 2)
            {
                if (target == nums[i])
                {
                    return i;
                }
                else if (target == nums[j])
                {
                    return j;
                }
                else if (target > nums[j])
                {
                    return j + 1;
                }    
                else if (target < nums[i])
                {
                    return i;
                }

                i++;
                j--;
            }
        }

       return toReturn;     
    }
}
