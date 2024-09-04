import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest
{

  @Test void removeElements1()
  {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(6);
    ListNode fourth = new ListNode(3);
    ListNode fifth = new ListNode(4);
    ListNode sixth = new ListNode(5);
    ListNode seventh = new ListNode(6);
    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    assertEquals("1->2->3->4->5->", Solution.printLL(Solution.removeElements(head, 6)));
  }

  @Test void removeElements2()
  {
    int[] values = {7, 7, 7, 7};

    ListNode head = new ListNode(values[0]);
    ListNode current = head;

    for (int i = 1; i < values.length; i++)
    {
      current.next = new ListNode(values[i]);
      current = current.next;
    }

    assertEquals("", Solution.printLL(Solution.removeElements(head, 7)));
  }
}
