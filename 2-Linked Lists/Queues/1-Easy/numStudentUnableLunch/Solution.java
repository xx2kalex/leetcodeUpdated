/**
 * LeetCode Queues Problem #1700
 * "Number of Students Unable to Eat Lunch"
 * 2024-08-01
 */
class Node
{
  Node next;
  int typeOfSandwich;

  public Node(int typeOfSandwich)
  {
    this.typeOfSandwich = typeOfSandwich;
  }
}

class Solution
{
  public static int countStudents(int[] students, int[] sandwiches)
  {
    Node head = new Node(students[0]);
    Node tail = head;
    Node current = head;

    int refusedCounter = 0;
    int lengthOfLine = students.length;

    for (int i = 1; i < students.length; i++)
    {
      current.next = new Node(students[i]);
      current = current.next;
      tail = current;
    }

    System.out.println("START OF THE ALGORITHM");
    printLL(head);
    printArray(sandwiches);
    System.out.println("=======================================\n\n");

    for (int i = 0; i < sandwiches.length; i++)
    {
      if (head.typeOfSandwich == sandwiches[i])
      {
        refusedCounter = 0; // reset refused counter

        lengthOfLine--;
        try
        {
          head = head.next;
        } catch (NullPointerException e)
        {
          // Edge case for when there is only one student in line, and they are satisfied with
          // their sandwich

          System.out.println("exception caught");
          return 0;
        }
        System.out.println("Pass, reducing list size");
      }
      else
      {
        refusedCounter++;

        Node oldHead = head;
        Node newHead = head.next;

        head = newHead;

        oldHead.next = null;
        tail.next = oldHead;

        tail = oldHead;

        // Go back to the same sandwich
        i = i - 1;

        if (refusedCounter >= lengthOfLine)
        {
          break;
        }

        System.out.println("Fail, moving head to the back and next student comes up");
      }

      printLL(head);
      printArray(sandwiches);
    }

    return refusedCounter;
  }


  public static void main(String[] args)
  {
    int[] students = {0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1};
    int[] sandwiches = {1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0};

    System.out.println(countStudents(students, sandwiches));
  }

  private static void printLL(Node head)
  {
    Node current;
    current = head;

    String output = "";

    while (current != null)
    {
      output = output + current.typeOfSandwich + "->";
      current = current.next;
    }

    System.out.println("Queue: " + output);
  }

  private static void printArray(int[] array)
  {
    String output = "";

    for (int i = 0; i < array.length; i++)
    {
      output = output + array[i] + "->";
    }

    System.out.println("Sandwiches: " + output);
  }
}
