/**
 * LeetCode 150
 * "Merge Two Linked Lists"
 * 2024-06-30
 */

class Solution
{
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2)
  {
    ListNode start = new ListNode(0);
    ListNode current = start;
    ListNode head1 = list1;
    ListNode head2 = list2;

    if (head1 == null && head2 == null)
    {
      return null;
    }

    while ((head1 != null) && (head2 != null))
    {
      if (head1.val < head2.val)
      {
        current.next = head1;
        head1 = head1.next;
      }
      else
      {
        current.next = head2;
        head2 = head2.next;
      }

      current = current.next;
    }

    if (head1 != null)
    {
      while (head1 != null)
      {
        current.next = head1;
        head1 = head1.next;

        current = current.next;
      }
    }

    if (head2 != null)
    {
      while (head2 != null)
      {
        current.next = head2;
        head2 = head2.next;

        current = current.next;
      }
    }

    return start.next;
  }

  public static void main(String[] args)
  {
    ListNode head1 = new ListNode(-9);
    head1.next = new ListNode(3);

    ListNode head2 = new ListNode(5);
    head2.next = new ListNode(7);

    ListNode mergedList = mergeTwoLists(head1, head2);

    printList(mergedList);
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
