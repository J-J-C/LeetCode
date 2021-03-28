package medium;

import java.util.*;

public class Num1229_MeetingScheduler {

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

    Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
    Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));

    int point1 = 0;
    int point2 = 0;
    while (point1 < slots1.length && point2 < slots2.length) {
      int[] people1 = slots1[point1];
      int[] people2 = slots2[point2];

      int start = Math.max(people1[0], people2[0]);
      int end = Math.min(people1[1], people2[1]);

      if (end - start >= duration) {
        List<Integer> result = new ArrayList<>();

        result.add(start);
        result.add(start + duration);
        return result;
      }
      if (point1 == slots1.length - 1 && point2 == slots2.length - 1) {
        break;
      }

      if (people1[1] < people2[1]) {
        point1++;
      } else {
        point2++;
      }
    }

    return new ArrayList<>();
  }

  public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
    PriorityQueue<int[]> timeslots = new PriorityQueue<>(Comparator.comparingInt(slot -> slot[0]));

    for (int[] slot : slots1) {
      if (slot[1] - slot[0] >= duration) {
        timeslots.offer(slot);
      }
    }
    for (int[] slot : slots2) {
      if (slot[1] - slot[0] >= duration) {
        timeslots.offer(slot);
      }
    }

    while (timeslots.size() > 1) {
      int[] slot1 = timeslots.poll();
      int[] slot2 = timeslots.peek();
      if (slot1[1] >= slot2[0] + duration) {
        return new ArrayList<>(Arrays.asList(slot2[0], slot2[0] + duration));
      }
    }
    return new ArrayList<>();
  }
}
