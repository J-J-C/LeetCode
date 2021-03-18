package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Num973_KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));

    for (int[] point : points) {
      pq.add(point);
    }
    List<int[]> result = new ArrayList<>();
    while (k > 0) {
      result.add(pq.poll());
      k--;
    }
    return result.toArray(new int[0][0]);
  }
}
