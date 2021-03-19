package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Num266_PalindromePermutation {

  public boolean canPermutePalindrome(String s) {

    if (s.length() <= 1) {
      return true;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    if (map.size() <= 2) {
      return true;
    }
    Set<Character> set = map.keySet().stream().collect(Collectors.toSet());
    for (char c : set) {
      if (map.containsKey(c) && map.get(c) % 2 == 0) {
        map.remove(c);
      }
    }

    return (s.length() % 2 != 0) ? (map.size() <= 1) : map.isEmpty();
  }

  public boolean canPermutePalindromeSet(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (!set.add(s.charAt(i))) {
        set.remove(s.charAt(i));
      }
    }
    return set.size() <= 1;
  }

  public boolean canPermutePalindromeOnePass(String s) {
    int[] map = new int[128];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i)]++;
      if (map[s.charAt(i)] % 2 == 0) {
        count--;
      } else {
        count++;
      }
    }
    return count <= 1;
  }
}
