/**
 * LeetCode Array Problem #682
 * "Baseball Game"
 * 2024-06-19
 */

import java.util.ArrayList;

class Solution
{
  public static int calPoints(String[] operations)
  {
    ArrayList<Integer> summingScores = new ArrayList<Integer>(); // list/stack of scores
    int x; // a standalone score input
    int sum; // the result of the "+" operation
    int doubleScore; // the result of the "D" operation
    for (int i = 0; i < operations.length; i++)
    {
      if (operations[i].equals("+"))
      {
        // Sums the last two scores together
        sum = summingScores.get(summingScores.size() - 1) + summingScores.get(
            summingScores.size() - 2);

        // Adds the newly summed scores to the list of scores
        summingScores.add(sum);
      }
      else if (operations[i].equals("D"))
      {
        // Doubles the last score
        doubleScore = summingScores.get((summingScores.size() - 1)) * 2;

        // Adds the newly doubled score to the list of scores
        summingScores.add(doubleScore);
      }
      else if (operations[i].equals("C"))
      {
        summingScores.remove(summingScores.size() - 1);
      }
      else
      {
        try
        {
          x = Integer.parseInt(operations[i]);
          summingScores.add(x);
        }
        catch (IllegalArgumentException e)
        {
          System.out.println("Error, invalid operation: " + operations[i]);
        }
      }
    }

    int score = calculateScore(summingScores);
    return score;
  }

  /**
   * Helper method to calculate the new score after an operation
   * @param nums
   * @return
   */
  public static int calculateScore(ArrayList<Integer> nums)
  {
    int score = 0;
    for (int i = 0; i < nums.size(); i++)
    {
      score = score + nums.get(i);
    }

    return score;
  }

  public static void main(String[] args)
  {
    String[] ops = {"1","C"};
    System.out.println(calPoints(ops));
  }
}
