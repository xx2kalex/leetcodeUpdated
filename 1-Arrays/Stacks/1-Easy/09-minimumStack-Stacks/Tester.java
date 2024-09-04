public class Tester
{
  private static String printLL(MinStack ms)
  {
    Node current = ms.tail;
    String output = "";

    while (current != null)
    {
      output = output + current.val + "<";
      current = current.prev;
    }

    return output;
  }

  private static boolean test1()
  {
    MinStack ms = new MinStack();
    ms.push(2);
    ms.push(0);
    ms.push(3);
    ms.push(0);
    ms.pop();
    ms.pop();
    ms.pop();

    ms.getMin();

    return true;
  }

  public static void main(String[] agrs)
  {
    test1();
  }

}
