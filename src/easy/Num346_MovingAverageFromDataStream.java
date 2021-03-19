package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Num346_MovingAverageFromDataStream {
}

class MovingAverage {

  Queue<Integer> queue = new LinkedList<>();
  int maxSize = 0;
  double currentSum = 0;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    this.maxSize = size;
  }

  public double next(int val) {
    if (queue.size() == maxSize) {
      currentSum -= queue.poll();
    }
    queue.add(val);
    currentSum += val;
    return currentSum / queue.size();
  }
}
