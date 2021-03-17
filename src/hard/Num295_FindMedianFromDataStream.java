package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Num295_FindMedianFromDataStream {
}

class MedianFinder {

  // we will have our min queue to always store one extra
  private final PriorityQueue<Double> minQueueMaxTop;
  private final PriorityQueue<Double> maxQueueMinTop;

  public MedianFinder() {
    this.minQueueMaxTop = new PriorityQueue<>(Comparator.reverseOrder());
    this.maxQueueMinTop = new PriorityQueue<>();
  }

  public void addNum(int num) {
    double n = num;
    minQueueMaxTop.add(n);
    maxQueueMinTop.add(minQueueMaxTop.poll());

    if (minQueueMaxTop.size() < maxQueueMinTop.size()) {
      minQueueMaxTop.add(maxQueueMinTop.poll());
    }
  }

  public double findMedian() {

    if (maxQueueMinTop.size() != minQueueMaxTop.size()) {
      return maxQueueMinTop.peek();
    } else {
      return minQueueMaxTop.size() == 0 ? 0 : (minQueueMaxTop.peek() + maxQueueMinTop.peek()) / 2;
    }
  }
}
