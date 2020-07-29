package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num49_GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    if (strs.length == 0) {
      return new ArrayList<>(map.values());
    }
    map.put(strs[0], new ArrayList<>());
    map.get(strs[0]).add(strs[0]);

    for (int i = 1; i < strs.length; i++) {
      String s = strs[i];
      boolean found = false;
      for (String key : map.keySet()) {
        if (isAnagram(s, key)) {
          map.get(key).add(s);
          found = true;
          break;
        }
      }
      if (!found) {
        map.put(strs[i], new ArrayList<>());
        map.get(strs[i]).add(strs[i]);
      }
    }
    return new ArrayList<>(map.values());
  }


  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      table[t.charAt(i) - 'a']--;
      if (table[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public List<List<String>> groupAnagramsFaster(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList();
    }
    Map<String, List> ans = new HashMap<>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

}
