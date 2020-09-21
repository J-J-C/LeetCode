package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num763_PartitionLabel {

  public static void main(String[] args) {
    String s = "ababcbacadefegdehijhklij";

    partitionLabels(s);
  }

  public static List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int[] firstOccurrence = new int[26];
    Map<Character, Integer> lastOccurrence = new HashMap<>();

    int index = 0;
    for (char c : s.toCharArray()) {
      if (!lastOccurrence.containsKey(c)) {
        firstOccurrence[c - 'a'] = index;
        lastOccurrence.put(c, index);
      } else {
        lastOccurrence.put(c, index);
      }
      index++;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int firstOccur = firstOccurrence[c - 'a'];
      int lastOccur = lastOccurrence.get(c);
      int jump = lastOccur;
      for (int j = firstOccur + 1; j < jump; j++) {
        char d = s.charAt(j);

        int dLastOccur = lastOccurrence.get(d);
        if (dLastOccur > jump) {
          jump = dLastOccur;
        }
      }
      result.add(jump - firstOccur + 1);
      i = jump;
    }
    return result;
  }

  public List<Integer> partitionLabelsOptimal(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      last[s.charAt(i) - 'a'] = i;
    }

    int end = 0;
    int start = 0;
    List<Integer> ans = new ArrayList();
    for (int i = 0; i < s.length(); ++i) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        ans.add(i - start + 1);
        start = i + 1;
      }
    }
    return ans;
  }
}
