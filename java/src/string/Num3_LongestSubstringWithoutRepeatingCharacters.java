package src.string;

import java.util.HashMap;
import java.util.Map;

public class Num3_LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubString(String s) {
    int max = 0;

    Map<Character, Integer> table = new HashMap<>();
    int head = 0;
    int tail = 0;

    while (tail != s.length()) {
      max = Math.max(tail - head, max);
      if (table.containsKey(s.charAt(tail))) {
        if (table.get(s.charAt(tail)) < head) {
          table.put(s.charAt(tail), tail);
          tail++;
          continue;
        }
        head = table.get(s.charAt(tail)) + 1;
      }
      table.put(s.charAt(tail), tail);
      tail++;
    }
    return Math.max(tail - head, max);
  }
}
