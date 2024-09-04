/**
 * LeetCode Prefix Sum Problem #303
 * "Range Sum Query - Immutable"
 * 2024-07-22
 */
class NumArray
{
  int[] prefixSum;

  public NumArray(int[] nums)
  {
    this.prefixSum = new int[nums.length];
    this.prefixSum[0] = nums[0];

    for (int i = 1; i < nums.length; i++)
    {
      this.prefixSum[i] = nums[i] + this.prefixSum[i - 1];
    }
  }

  public int sumRange(int left, int right)
  {
    if (left != 0)
    {
      return this.prefixSum[right] - this.prefixSum[left - 1];
    }
    return prefixSum[right];
  }
}

