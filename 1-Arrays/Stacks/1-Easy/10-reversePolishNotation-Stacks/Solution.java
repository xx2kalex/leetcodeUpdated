/**
 * NeetCode 150
 * "Evaluate Reverse Polish Notation"
 * 2024-06-25
 */

import java.util.ArrayList;

class Solution
{
  public static int evalRPN(String[] tokens)
  {
    ArrayList<Integer> values = new ArrayList<>();
    int asInt;
    int value1;
    int value2;
    for (int i = 0; i < tokens.length; i++)
    {
      try
      {
        asInt = Integer.parseInt(tokens[i]);
        values.add(asInt);
      }
      catch (Exception e)
      {
        value1 = values.remove(values.size() - 1);
        value2 = values.remove(values.size() - 1);

        if (tokens[i].equals("+"))
        {
          values.add(value1 + value2);
        }
        else if (tokens[i].equals("-"))
        {
          values.add(value2 - value1);
        }
        else if (tokens[i].equals("*"))
        {
          values.add(value1 * value2);
        }
        else if (tokens[i].equals("/"))
        {
          values.add(value2 / value1);
        }
        else
        {
          throw new IllegalArgumentException("Illegal operand");
        }
      }
    }

    int toReturn = values.get(values.size() - 1);
    return toReturn;
  }

  public static void main(String[] args)
  {
    String[] values = {"1", "2", "+", "3", "*", "4", "-"};
    System.out.println(evalRPN(values));
  }
}
