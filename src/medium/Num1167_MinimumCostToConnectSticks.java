package medium;

import java.util.PriorityQueue;

public class Num1167_MinimumCostToConnectSticks {

  public int connectSticks(int[] sticks) {
    if (sticks.length <= 1) {
      return 0;
    }

    int cost = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int s : sticks) {
      priorityQueue.add(s);
    }

    while (priorityQueue.size() > 1) {
      int a = priorityQueue.poll();
      int b = priorityQueue.poll();
      cost += a + b;
      priorityQueue.add(a + b);
    }
    return cost;
  }
}
