package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num242_ValidAnagram {

  public boolean isAnagram1(String s, String t) {
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();

    Arrays.sort(sArray);
    Arrays.sort(tArray);

    return Arrays.equals(sArray, tArray);
  }

  public boolean isAnagram2(String s, String t) {
    Map<Character, Integer> memory = new HashMap<>();
    for (char c : s.toCharArray()) {
      memory.computeIfPresent(c, (key, v) -> v + 1);
      memory.putIfAbsent(c, 1);
    }
    for (char c : t.toCharArray()) {
      if (!memory.containsKey(c)) {
        return false;
      } else {
        if (memory.get(c) == 1) {
          memory.remove(c);
        } else {
          memory.computeIfPresent(c, (k, v) -> v - 1);
        }
      }
    }
    return memory.isEmpty();
  }

  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      int i1 = table[t.charAt(i) - 'a'];
      i1--;
      if (i1 < 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram4(String s, String t) {
    Map<Character, Integer> memory = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (memory.containsKey(c)) {
        memory.computeIfPresent(c, (key, v) -> v + 1);

      } else {
        memory.put(c, 1);
      }
    }
    for (char c : t.toCharArray()) {
      if (!memory.containsKey(c)) {
        return false;
      } else {
        if (memory.get(c) == 1) {
          memory.remove(c);
        } else {
          memory.computeIfPresent(c, (k, v) -> v - 1);
        }
      }
    }
    return memory.isEmpty();
  }

  public boolean isAnagram5(String s, String t) {
    Map<Character, Integer> memory = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (memory.containsKey(c)) {
        memory.put(c, memory.get(c) + 1);

      } else {
        memory.put(c, 1);
      }
    }
    for (char c : t.toCharArray()) {
      if (!memory.containsKey(c)) {
        return false;
      } else {
        if (memory.get(c) == 1) {
          memory.remove(c);
        } else {
          memory.put(c, memory.get(c) - 1);
        }
      }
    }
    return memory.isEmpty();
  }
}
