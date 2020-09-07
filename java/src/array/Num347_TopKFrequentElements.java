package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Num347_TopKFrequentElements {


  public int[] topKFrequent(int[] nums, int k) {
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap<>();

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
        (o1, o2) -> map.get(o2) - map.get(o1));
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.compute(num, (key, value) -> value + 1);
      } else {
        map.put(num, 1);
      }
    }

    for (int num : map.keySet()) {
      priorityQueue.add(num);
    }
    int index = 0;
    while (index < k) {
      result[index] = priorityQueue.poll();
      index++;
    }
    return result;
  }
}
