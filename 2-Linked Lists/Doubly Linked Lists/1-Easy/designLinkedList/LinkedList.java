/**
 * LeetCode Linked List Problem #707
 * "Design Linked List"
 * 2024-07-18
 */
class Node
{
  int val;
  Node next;
  Node prev;

  Node()
  {
  }

  Node(int val)
  {
    this.val = val;
  }

  Node(int val, Node next)
  {
    this.val = val;
    this.next = next;
  }

  Node(int val, Node prev, Node next)
  {
    this.val = val;
    this.next = next;
    this.prev = prev;
  }
}


class MyLinkedList
{
  Node head;
  Node tail;

  public MyLinkedList()
  {
    this.head = null;
    this.tail = null;
  }

  public int get(int index)
  {
    Node current = head;
    int counter = 0;

    while (current != null)
    {
      if (counter == index)
      {
        System.out.println("You got: " + current.val);

        return current.val;
      }
      else
      {
        counter++;
        current = current.next;
      }
    }


    return -1;
  }

  public void addAtHead(int val)
  {
    Node nodeToAdd = new Node(val);

    if (head == null)
    {
      // List is empty
      head = nodeToAdd;
      tail = nodeToAdd;
    }
    else
    {
      // ->
      nodeToAdd.next = head;
      head = nodeToAdd;

      // <-
      nodeToAdd.next.prev = nodeToAdd;
    }
  }

  public void addAtTail(int val)
  {
    Node nodeToAdd = new Node(val);
    if (head == null)
    { // List is empty
      head = nodeToAdd;
      tail = nodeToAdd;
    }
    else
    {
      tail.next = nodeToAdd;
      nodeToAdd.prev = tail;
      tail = tail.next;
    }
  }

  public void addAtIndex(int index, int val)
  {
    if (index > getLength(head))
    {
      // Invalid index
      return;
    }
    if (index == 0)
    {
      addAtHead(val);
    }
    if (index == getLength(head))
    {
      addAtTail(val);
    }
    else
    {
      Node nodeToAdd = new Node(val);
      Node current = head;
      int counter = 0;

      while (current != null)
      {
        if (counter == index - 1)
        {
          nodeToAdd.next = current.next;
          if (current.next != null)
          {
            current.next.prev = nodeToAdd;
          }
          current.next = nodeToAdd;
          nodeToAdd.prev = current;
          break;
        }
        else
        {
          counter++;
          current = current.next;
        }
      }
    }
  }

  public void deleteAtIndex(int index)
  {
    if (index < 0 || index >= getLength(head))
    {
      // Invalid index
      return;
    }
    else if (index == 0)
    {
      if (head == tail)
      {
        head = null;
        tail = null;
      }
      else
      {
        head = head.next;
        if (head != null)
        {
          head.prev = null;
        }
      }
    }
    else if (index == getLength(head) - 1)
    {
      tail = tail.prev;
      tail.next = null;
    }
    else
    {
      Node current = head;
      int counter = 0;

      while (current != null)
      {
        if (counter == index - 1)
        {
          if (current.next.next != null)
          {
            current.next.next.prev = current;
            current.next = current.next.next;

          }
          else
          {
            current.next = null;
          }

          break;
        }
        else
        {
          counter++;
          current = current.next;
        }
      }
    }
  }

  private int getLength(Node head)
  {
    Node current = head;
    int length = 0;

    while (current != null)
    {
      length++;
      current = current.next;
    }

    return length;
  }
}




