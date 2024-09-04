/**
 * LeetCode Linked List Problem #141
 * "Linked List Cycle"
 * 2024-07
 */
public class Solution
{
  public boolean hasCycle(ListNode head)
  {
    ListNode tortoise;
    ListNode hare;
    tortoise = head;
    hare = head;

    while (hare != null && tortoise != null)
    {
      try
      {
        hare = hare.next.next;
        tortoise = tortoise.next;
      }
      catch (NullPointerException e)
      {
        return false;
      }
      if (hare == tortoise)
      {
        return true;
      }
    }

    return false;
  }


  public static void main(String[] args)
  {
    ListNode head = new ListNode(3);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(0);
    ListNode fourth = new ListNode(4);
    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = second;

    Solution sol = new Solution();
    System.out.println(sol.hasCycle(head));
  }
}
