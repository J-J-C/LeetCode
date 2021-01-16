package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num392_IsSubsequence {

  public boolean isSubsequence(String s, String t) {

    int pointer = 0;
    for (int i = 0; i < t.length(); i++) {
      if (pointer == s.length()) {
        return true;
      }
      if (t.charAt(i) == s.charAt(pointer)) {
        pointer++;
      }
    }
    return pointer == s.length();
  }


  public boolean isSubsequence2(String s, String t) {
    if (s == null || t == null) return false;

    Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

    //preprocess t
    for (int i = 0; i < t.length(); i++) {
      char curr = t.charAt(i);
      if (!map.containsKey(curr)) {
        map.put(curr, new ArrayList<Integer>());
      }
      map.get(curr).add(i);
    }

    int prev = -1;  //index of previous character
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (map.get(c) == null) {
        return false;
      } else {
        List<Integer> list = map.get(c);
        prev = binarySearch(prev, list, 0, list.size() - 1);
        if (prev == -1) {
          return false;
        }
        prev++;
      }
    }

    return true;
  }

  private int binarySearch(int index, List<Integer> list, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (list.get(mid) < index) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return start == list.size() ? -1 : list.get(start);
  }

  public boolean isSubsequenceBest(String s, String t) {

    // precomputation, build the hashmap out of the target string
    HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
    for (int i = 0; i < t.length(); ++i) {
      if (letterIndicesTable.containsKey(t.charAt(i)))
        letterIndicesTable.get(t.charAt(i)).add(i);
      else {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(i);
        letterIndicesTable.put(t.charAt(i), indices);
      }
    }

    Integer currMatchIndex = -1;
    for (char letter : s.toCharArray()) {
      if (!letterIndicesTable.containsKey(letter))
        return false; // no match, early exist

      boolean isMatched = false;
      // greedy match with linear search
      for (Integer matchIndex : letterIndicesTable.get(letter)) {
        if (currMatchIndex < matchIndex) {
          currMatchIndex = matchIndex;
          isMatched = true;
          break;
        }
      }

      if (!isMatched)
        return false;
    }

    // consume all characters in the source string
    return true;
  }
}
