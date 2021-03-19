package easy;

import java.util.*;

public class Num1086_HighFive {

  public int[][] highFive(int[][] items) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for (int[] array : items) {
      PriorityQueue<Integer> pq = map.getOrDefault(array[0], new PriorityQueue<>());
      if (pq.size() == 5) {
        if (array[1] > pq.peek()) {
          pq.poll();
          pq.add(array[1]);
        }
      } else {
        pq.add(array[1]);
      }
      map.put(array[0], pq);
    }

    Integer[] studentIds = map.keySet().toArray(new Integer[0]);
    Arrays.sort(studentIds);

    List<int[]> result = new ArrayList<>();
    for (int studentId : studentIds) {
      int average = map.get(studentId).stream().reduce(0, Integer::sum) / map.get(studentId).size();
      result.add(new int[]{studentId, average});
    }
    return result.toArray(new int[0][]);
  }
}
