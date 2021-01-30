package dp_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Num253_MeetingRoom2 {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int[] meeting : intervals) {
      if (pq.isEmpty()) {
        pq.add(meeting[1]);
        continue;
      }
      if (meeting[0] < pq.peek()) {
        pq.add(meeting[1]);
      } else {
        pq.poll();
        pq.add(meeting[1]);
      }
    }
    return pq.size();
  }
}
