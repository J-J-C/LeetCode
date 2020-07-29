package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num387_FirstUniqueCharacterInAString {

  public static void main(String[] args) {
    System.out.println(firstUniqCharArray("leetcode"));
  }

  public static int firstUniqCharArray(String s) {

    int[] map = new int[26];
    Arrays.fill(map, -1);
    char base = 'a';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map[c - base] == -1) {
        map[c - base] = i;
      } else {
        map[c - base] = Integer.MAX_VALUE;
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i : map) {
      if (i < min && i != -1) {
        min = i;
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, i);
      } else {
        map.put(c, Integer.MAX_VALUE);
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i : map.values()) {
      if (i < min) {
        min = i;
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
