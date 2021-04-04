package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Num347_TopFrequentElement {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }

    PriorityQueue<Integer> pq =
            new PriorityQueue<>((o1, o2) -> -(map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0)));

    for (int i : map.keySet()) {
      pq.add(i);
    }
    int index = 0;
    int[] result = new int[k];
    while (index < k) {
      result[index] = pq.poll();
    }
    return result;
  }
}
