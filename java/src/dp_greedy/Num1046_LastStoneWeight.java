package dp_greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Num1046_LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    for (int weight : stones) {
      priorityQueue.add(weight);
    }

    while (!priorityQueue.isEmpty() && priorityQueue.size() != 1) {
      int firstWeight = priorityQueue.poll();
      int secondWeight = priorityQueue.poll();
      int diff = firstWeight - secondWeight;
      if (diff > 0) {
        priorityQueue.add(diff);
      }
    }

    return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
  }
}
