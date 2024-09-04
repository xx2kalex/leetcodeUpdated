/**
 * NeetCode 150
 * "Valid Parentheses"
 * 2024-06-23
 */

import java.util.ArrayList;

class Solution
{
  public static boolean isValid(String s)
  {
    ArrayList<Character> stack = new ArrayList<>();
    char c;

    if (s.length() % 2 != 0)
    {
      // String cannot have an odd number of characters
      return false;
    }


    // Adds all the characters in the String to a stack
    for (int i = 0; i < s.length(); i++)
    {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
      {
        // Add the opening bracket to the top of the stack and move on to next char
        stack.add(s.charAt(i));
        continue;
      }
      if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
      {
        // First character cannot be a closing bracket
        return false;
      }
      else
      {
        if (stack.isEmpty())
        {
          // This means that there are no opening brackets to compare with
          return false;
        }
        c = stack.remove(stack.size() - 1);
        if (c == '(' && s.charAt(i) != ')')
        {
          return false;
        }
        else if (c == '[' && s.charAt(i) != ']')
        {
          return false;
        }
        else if (c == '{' && s.charAt(i) != '}')
        {
          return false;
        }
      }
    }

    if (!stack.isEmpty())
    {
      // IF we have successful orderings, the stack should be empty by the end of the iterations
      return false;
    }

    return true;
  }

  public static void main(String[] args)
  {
    String s = "((";
    System.out.println(isValid(s));
  }
}
