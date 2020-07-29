package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Num1054_DisntantBarcodes {

  public static void main(String[] args) {
    int[] array = {1, 1, 1, 2, 2, 2};
    System.out.println(Arrays.toString(rearrangeBarcodes(array)));

    int[] array1 = {2, 1, 1};
    System.out.println(Arrays.toString(rearrangeBarcodes(array1)));
  }

  public static int[] rearrangeBarcodes2(int[] barcodes) {
    if (barcodes.length <= 2) {
      return barcodes;
    }
    int[] result = new int[barcodes.length];
    Arrays.fill(result, -1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : barcodes) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    List<Integer> candidates = new ArrayList(map.keySet());
    Collections.sort(candidates, (w1, w2) -> -1 * (map.get(w1) - map.get(w2)));

    int i = 0;
    for (int key : candidates) {
      int total = map.get(key);
      while (total > 0) {
        result[i] = key;
        i += 2;
        if (i >= barcodes.length) {
          i = 1;
        }
        total--;
      }
    }
    return result;
  }


  public static int[] rearrangeBarcodes(int[] barcodes) {
    if (barcodes.length <= 2) {
      return barcodes;
    }
    int[] result = new int[barcodes.length];
    Arrays.fill(result, -1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : barcodes) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> leftOver = new PriorityQueue<>((o1, o2) -> {
      return map.get(o2) - map.get(o1);
    });
    for (int key : map.keySet()) {
      leftOver.add(key);
    }
    int index = 0;
    while (!leftOver.isEmpty()) {
      int key1 = leftOver.poll();
      System.out.println(key1);
      result[index] = key1;
      index++;
      if (!leftOver.isEmpty()) {
        int key2 = leftOver.poll();
        result[index] = key2;
        index++;
        map.put(key1, map.get(key1) - 1);
        map.put(key2, map.get(key2) - 1);
        if (map.get(key1) > 0) {
          leftOver.add(key1);
        }
        if (map.get(key2) > 0) {
          leftOver.add(key2);
        }
      } else {
        map.put(key1, map.get(key1) - 1);
        if (map.get(key1) > 0) {
          leftOver.add(key1);
        }
      }
    }
    return result;
  }

  public int[] rearrangeBarcodesOn(int[] barcodes) {
    int maxFreqCode = 0, i = 0, n = barcodes.length;
    int[] freq = new int[10_001], ans = new int[n];
    for (int c : barcodes) { // count the frequency of each code.
      if (++freq[c] > freq[maxFreqCode]) { // update the code of max frequency.
        maxFreqCode = c;
      }
    }
    for (int j = 0; j < freq.length; ++j) {
      int code = j == 0 ? maxFreqCode : j; // fill in most frequent code first.
      while (freq[code]-- > 0) { // fill codes of positive frequencies.
        ans[i] = code;
        i = i + 2 < n ? i + 2 : 1; // fill even indices first, if depleted, use odd ones.
      }
    }
    return ans;
  }
}
