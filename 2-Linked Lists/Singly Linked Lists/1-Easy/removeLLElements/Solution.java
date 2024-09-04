/**
 * LeetCode Linked List Problem #203
 * "Remove Linked List Elements"
 * 2024-07
 */

class Solution
{
  public static ListNode removeElements(ListNode head, int val)
  {
    ListNode currentNode = head;
    ListNode currentHead = head;

    // With an empty Linked List, simply return null
    if (currentHead == null)
    {
      return null;
    }

    while (currentNode != null)
    {
      if (currentHead.val == val)
      {
        // Illegal head, move head pointer to the next node
        currentHead = currentHead.next;
        currentNode = currentNode.next;
      }
      else
      {
        // The head is legal, and we can move on to the body
        break;
      }
    }

    if (currentHead != null)
    {
      // Reset currentNode pointer to original head
      currentNode = head;
    }
    else
    {
      // There are no more nodes in the linked list
      return null;
    }


    while (currentNode != null)
    {
      if (currentNode.next != null && currentNode.next.val == val)
      {
        // The next value in the linked list is illegal
        currentNode.next = currentNode.next.next; // "skip" the next value because it is illegal
        if (currentNode.next != null && currentNode.next.val == val)
        {
          try
          {
            // Handles the case of b2b illegal nodes
            while (currentNode.next.val == val)
            {
              currentNode.next = currentNode.next.next;
            }
          }
          catch (NullPointerException e)
          {
            // exit the loop if we encounter a null node
            break;
          }
        }
      }
      else
      {
        // If the next node is not illegal, move on
        currentNode = currentNode.next;
      }
    }

    return currentHead;
  }

  /**
   * Helper method to print the linked list
   * @param head - the head of the linked list
   */
  public static String printLL(ListNode head)
  {
    ListNode current = head;
    String output = "";

    while (current != null)
    {
      output = output + current.val + "->";
      current = current.next;
    }

    return output;
  }
}
