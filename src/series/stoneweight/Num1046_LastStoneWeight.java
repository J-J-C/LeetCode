package series.stoneweight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Num1046_LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int s : stones) {
      priorityQueue.add(s);
    }

    while (priorityQueue.size() > 1) {
      int s1 = priorityQueue.poll();
      int s2 = priorityQueue.poll();
      int diff = s1 - s2;
      if (diff > 0) {
        priorityQueue.add(diff);
      }
    }

    return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
  }
}
