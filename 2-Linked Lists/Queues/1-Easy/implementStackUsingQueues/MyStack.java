/**
 * LeetCode Queues Problem #225
 * "Implement Stack using Queues"
 * 2024-08-01
 */
class Node
{
  Node next;
  int val;

  public Node(int val)
  {
    this.val = val;
  }
}


class MyStack
{
  Node head;
  Node tail = head;
  Node current = head;

  public MyStack()
  {

  }

  public void push(int x)
  {
    Node newTail = new Node(x);

    if (head == null)
    {
      head = newTail;
      tail = newTail;
    }
    else
    {
      tail.next = newTail;
      tail = newTail;
    }

    System.out.println("Pushed value: " + newTail.val + " resulting in LL: ");
    printLL(head);
  }

  public int pop()
  {
    Node current = head;
    int toReturn = head.val;

    while (current != null)
    {
      if (current.next != null)
      {
        if (current.next.next == null)
        {
          tail = current;
          toReturn = tail.next.val;
          tail.next = null;

          break;
        }

        current = current.next;
      }
      else
      {
        head = null;
        tail = null;
        break;
      }
    }

    System.out.println("Popped value: " + toReturn + " resulting in LL: ");
    printLL(head);

    return toReturn;
  }

  public int top()
  {
    return tail.val;
  }

  public boolean empty()
  {
    return head == null && tail == null;
  }


  private static void printLL(Node head)
  {
    Node current;
    current = head;

    String output = "";

    while (current != null)
    {
      output = output + current.val + "->";
      current = current.next;
    }

    System.out.println("Queue: " + output);
  }
}
