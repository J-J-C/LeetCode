package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Num253_MeetingRooms2 {
  public int minMeetingRooms(int[][] intervals) {

    if (intervals.length == 0) {
      return 0;
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

    PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();

    for (int[] array : intervals) {
      priorityQueue.add(array);
    }

    int[] first = priorityQueue.poll();
    endTimePQ.add(first[1]);
    while (!priorityQueue.isEmpty()) {
      int[] meeting = priorityQueue.poll();
      if (meeting[0] >= endTimePQ.peek()) {
        endTimePQ.poll();
      }
      endTimePQ.add(meeting[1]);
    }

    return endTimePQ.size();
  }
}
