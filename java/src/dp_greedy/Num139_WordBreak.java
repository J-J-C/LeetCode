package dp_greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num139_WordBreak {

  public static void main(String[] args) {
    String s = "catsandogcat";
    List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat", "an");
    System.out.println(wordBreak(s, dict));
    System.out.println("--------------------");
    s = "applepenapple";
    dict = Arrays.asList("apple", "pen");
    System.out.println(wordBreak(s, dict));
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, new HashSet<>(wordDict), 0, new int[s.length() + 1]);
  }

  public static boolean wordBreak(String s, Set<String> wordDict, int startIndex, int[] array) {
    if (wordDict.contains(s)) {
      return true;
    }
    if (array[startIndex] == 1) {
      return false;
    } else if (array[startIndex] == 2) {
      return true;
    }
    boolean found = false;
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      builder.append(s.charAt(i));
      if (wordDict.contains(builder.toString())) {
        found = found || wordBreak(s.substring(i + 1), wordDict, i + startIndex, array);
      }
    }
    array[startIndex] = found ? 2 : 1;
    return found;
  }
}
