package series.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Num362_DesignHitCounter {
}

class HitCounter {

  Map<Integer, Integer> timeHitMap = new HashMap<>();

  // five minutes
  static final int MAX_TIME_GAP = 300;
  int total = 0;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    timeHitMap = new HashMap<>();
  }

  /*
  we may use concurrent hashmap or lock to avoid race condition
  in case of multiple hit
  */
  public void hit(int timestamp) {
    if (timeHitMap.containsKey(timestamp)) {
      timeHitMap.put(timestamp, timeHitMap.get(timestamp) + 1);
    } else {
      timeHitMap.put(timestamp, 1);
    }
    total++;
  }

  public int getHits(int timestamp) {
    int result = total;
    for (int key : timeHitMap.keySet()) {
      if (timestamp - key >= MAX_TIME_GAP) {
        result -= timeHitMap.get(key);
      }
    }
    return result;
  }
}

class HitCounterOriginal {

  Map<Integer, Integer> timeHitMap = new HashMap<>();
  PriorityQueue<Integer> timeStampQueue = new PriorityQueue<>();

  // five minutes
  static final int MAX_TIME_GAP = 300;

  /**
   * Initialize your data structure here.
   */
  public HitCounterOriginal() {
    timeHitMap = new HashMap<>();
    timeStampQueue = new PriorityQueue<>();
  }

  /*
  we may use concurrent hashmap or lock to avoid race condition
  in case of multiple hit
  */
  public void hit(int timestamp) {
    if (timeHitMap.containsKey(timestamp)) {
      timeHitMap.put(timestamp, timeHitMap.get(timestamp) + 1);
    } else {
      timeHitMap.put(timestamp, 0);
      timeStampQueue.add(timestamp);
    }
  }

  public int getHits(int timestamp) {
    PriorityQueue<Integer> tempQueue = new PriorityQueue<>(timeStampQueue);
    // we can pop out from original queue if no history needs to be maintained
    int total = 0;
    while (!tempQueue.isEmpty()) {
      int time = tempQueue.poll();
      if (timestamp - time > MAX_TIME_GAP) {
        timeStampQueue.poll();
      } else {
        total += timeHitMap.get(time);
      }
    }
    return total;
  }
}
