/**
 * LeetCode Stack Problem #155
 * "Min Stack"
 * 2024-07-24
 */
class Node
{
  int val;
  Node next;
  Node prev;
  int minOfStack;

  Node(int val, int minOfStack)
  {
    this.val = val;
    this.minOfStack = minOfStack;
  }
}

class MinStack
{
  Node tail;
  Node topNode = tail;

  public MinStack()
  {
  }

  public void push(int val)
  {
    if (topNode == null)
    {
      Node nodeToAdd = new Node(val, val);
      tail = nodeToAdd;
      topNode = nodeToAdd;
    }
    else
    {
      Node nodeToAdd = new Node(val, Math.min(val, topNode.minOfStack));

      topNode.prev = nodeToAdd;
      nodeToAdd.next = topNode;

      topNode = nodeToAdd;
    }
  }

  public void pop()
  {
    if (topNode.next != null)
    {
      topNode = topNode.next;
      topNode.prev = null;
    }
    else
    {
      topNode = null;
      tail = null;
    }
  }

  public int top()
  {
    return topNode.val;
  }

  public int getMin()
  {
    return topNode.minOfStack;
  }
}
