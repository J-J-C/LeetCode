package dp_greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Num763_PartitionLabels {

  public static void main(String[] args) {
    //
    String s = "ababcbacadefegdehijhklij";
    System.out.println(partitionLabels(s));
  }

  public static List<Integer> partitionLabels(String S) {

    List<String> partitions = new ArrayList<>();

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      System.out.println(i);
      System.out.println(c);
      int foundIndex = -1;
      for (int j = 0; j < partitions.size(); j++) {
        String partition = partitions.get(j);
        if (partition.contains("" + c)) {
          foundIndex = j;
          break;
        }
      }
      System.out.println("check");
      if (foundIndex > -1) {
        String p = partitions.get(foundIndex);
        List<String> toRemove = new ArrayList<>();
        for (int k = foundIndex + 1; k < partitions.size(); k++) {
          p = p + partitions.get(k);
          toRemove.add(partitions.get(k));
        }
        partitions.removeAll(toRemove);

        partitions.remove(foundIndex);
        partitions.add(p + c);
      } else {
        partitions.add("" + c);
      }
    }
    return partitions.stream().map(String::length).collect(Collectors.toList());
  }

  public List<Integer> partitionLabels2(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); ++i) {
      last[S.charAt(i) - 'a'] = i;
    }

    int j = 0, anchor = 0;
    List<Integer> ans = new ArrayList();
    for (int i = 0; i < S.length(); ++i) {
      j = Math.max(j, last[S.charAt(i) - 'a']);
      if (i == j) {
        ans.add(i - anchor + 1);
        anchor = i + 1;
      }
    }
    return ans;
  }
}
