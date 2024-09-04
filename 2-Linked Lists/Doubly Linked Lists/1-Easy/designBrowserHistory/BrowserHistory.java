/**
 * LeetCode Doubly Linked List Problem #1472
 * "Design Browser History"
 * 2024-07-22
 */
class Node
{
  String website;
  Node next;
  Node prev;

  Node()
  {
  }

  Node(String website)
  {
    this.website = website;
  }
}

class BrowserHistory
{
  Node current = null;
  Node head;
  int length;
  int currentIndex;

  public BrowserHistory(String homepage)
  {
    this.head = new Node(homepage);
    this.current = this.head;
    this.length = 1;
    this.currentIndex = 0;
  }

  /**
   * Visits url from the current page and clears up all the forward history
   * @param url - website url
   */
  public void visit(String url)
  {
    Node nodeToAdd = new Node(url);

    // current->NTA
    Node placeholderPointer = current.next;

    current.next = nodeToAdd;

    if (placeholderPointer != null)
    {
      // NTA->NTA.next
      nodeToAdd.next = placeholderPointer;
      // NTA<-NTA.next
      placeholderPointer.prev = nodeToAdd;
    }

    // current<-NTA
    nodeToAdd.prev = current;


    // Move current up to the newly added node
    current = nodeToAdd;

    // Deletes all the forward history
    Node temp = nodeToAdd.next;
    while (temp != null)
    {
      Node next = temp.next;
      temp.next = null;
      temp.prev = null;
      temp = next;
      length--;
    }

    current.next = null;

    length++;
    currentIndex++;
  }

  /**
   * Moves back in the list
   * @param steps - how many websites back we move
   * @return - url of the website where we land
   */
  public String back(int steps)
  {
    // Adjusts steps to maximum number of steps, if needed
    if (steps > currentIndex)
    {
      steps = currentIndex;
    }

    while (steps != 0)
    {
      current = current.prev;
      steps--;
      currentIndex--;
    }

    return current.website;
  }

  /**
   * Moves forward in the list
   * @param steps - how many websites forward we move
   * @return - url of the website where we land
   */
  public String forward(int steps)
  {
    // Adjusts steps to maximum number of steps, if needed
    if (steps > length - currentIndex - 1)
    {
      steps = length - currentIndex - 1;
    }

    while (steps != 0)
    {
      current = current.next;
      steps--;
      currentIndex++;
    }

    return current.website;
  }
}
