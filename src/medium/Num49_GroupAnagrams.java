package medium;

import java.util.*;
import java.util.stream.Collectors;

public class Num49_GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] array = s.toCharArray();
      Arrays.sort(array);
      String sortedString = new String(array);
      if (map.containsKey(sortedString)) {
        map.get(sortedString).add(s);
      } else {
        map.put(sortedString, new ArrayList<>());
        map.get(sortedString).add(s);
      }
    }

    return map.values().stream().collect(Collectors.toList());
  }
}
