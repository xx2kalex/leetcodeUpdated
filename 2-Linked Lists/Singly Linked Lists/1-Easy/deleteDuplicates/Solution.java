/**
 * LeetCode Linked List Problem #83
 * "Remove Duplicates from Sorted List"
 * 2024-07-01
 */
class Solution
{
  public ListNode deleteDuplicates(ListNode head)
  {
    ListNode current;
    current = head;

    while (current != null)
    {
      if (current.next == null)
      {
        break;
      }

      if ((current.next.next != null) && (current.next.val == current.val))
      {
        current.next = current.next.next;
        System.out.println("Skipping the next node because it is a duplicate");
        printList(head);
      }
      else if ((current.next.next == null) && (current.next.val == current.val))
      {
        System.out.println("Setting the next node to null because it is a duplicate");
        current.next = null;
        break;
      }
      else
      {
        System.out.println("Moving on to the next node");
        current = current.next;
      }
    }

    return head;
  }

  public static void main(String[] args)
  {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(3);
    head.next.next.next.next.next = new ListNode(3);


    Solution sol = new Solution();
    sol.deleteDuplicates(head);
    printList(head);
  }

  public static void printList(ListNode node)
  {
    while (node != null)
    {
      System.out.print(node.val);
      if (node.next != null)
      {
        System.out.print(" -> ");
      }
      node = node.next;
    }
    System.out.println();
  }
}
