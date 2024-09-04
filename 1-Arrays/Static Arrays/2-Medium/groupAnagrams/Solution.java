import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs)
  {
    List<List<String>> listOfAllAnagrams = new ArrayList<>();
    List<String> mutualAnagrams = new ArrayList<>();

    boolean anagrams;
    for (int i = 0; i < strs.length; i++)
    {
      for (int j = 0; j < strs[i].length(); j++)
      {
        if (!(strs[i].equals(strs[j])))
        {
          anagrams = isAnagram(strs[i], strs[j]);
          if (anagrams)
          {
            mutualAnagrams.add(strs[i]);
            mutualAnagrams.add(strs[j]);
            listOfAllAnagrams.add(mutualAnagrams);
          }
        }
      }
    }

    return listOfAllAnagrams;
  }

  /**
   * Helper method to determine whether a string is an anagram
   *
   * @param s - one string
   * @param t - another string
   * @return - true if the string is an anagram, false otherwise
   */
  private static boolean isAnagram(String s, String t)
  {
    boolean isAnagram = true;

    int sLength = s.length();
    int tLength = t.length();

    // Immediate return if string lengths are not equal
    if (sLength != tLength)
    {
      System.out.println("sLength != tLength");
      return false;
    }

    // Checking if every character in one string also exists in the other
    for (int i = 0; i < sLength; i++)
    {
      char currChar1 = s.charAt(i);
      boolean foundCurChar1 = false;

      for (int j = 0; j < tLength; j++)
      {
        if (currChar1 == t.charAt(j))
        {
          foundCurChar1 = true;
        }
        if (j == tLength - 1 && foundCurChar1 == false)
        {
          return false;
        }
      }

      // Checking that a particular character appears in one string the same amount of times as
      // in the other
      int amtOfCharInS = amtOfAChar(s, currChar1);
      int amtOfCharInT = amtOfAChar(t, currChar1);
      if (amtOfCharInS != amtOfCharInT)
      {
        return false;
      }
    }

    return isAnagram;
  }

  /**
   * Helper method to determine the amount of occurences of a specific character in a given string
   *
   * @param s - the string
   * @param c - the particular character
   * @return
   */
  private static int amtOfAChar(String s, char c)
  {
    int numMatches = 0;
    for (int i = 0; i < s.length(); i++)
    {
      char currChar = s.charAt(i);

      if (currChar == c)
      {
        numMatches++;
      }
    }

    return numMatches;
  }

}
