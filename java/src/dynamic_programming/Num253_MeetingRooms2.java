package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Num253_MeetingRooms2 {

  public static void main(String[] args) {
    int[][] array1 = {{0, 30}, {15, 20}, {5, 10}};
    System.out.println(minMeetingRooms(array1));

    int[][] array2 = {{9, 10}, {4, 9}, {4, 17}};
    System.out.println(minMeetingRooms(array2));

  }

  public static int minMeetingRooms(int[][] intervals) {
    // step 1: sort the intervals
    int maxMeetingRoom = 0;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    for (int[] array : intervals) {
      System.out.println(Arrays.toString(array));
    }

    PriorityQueue<Integer> timeEnd = new PriorityQueue<>();
    for (int[] array : intervals) {
      if (timeEnd.isEmpty()) {
        timeEnd.add(array[1]);
      } else {
        if (array[0] < timeEnd.peek()) {
          timeEnd.add(array[1]);
        } else {
          timeEnd.poll();
          timeEnd.add(array[1]);
        }
      }
      maxMeetingRoom = Math.max(maxMeetingRoom, timeEnd.size());
    }
    return maxMeetingRoom;
  }
}
