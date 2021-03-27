package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num1229_MeetingScheduler {

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

    // step 1: first sort the slot
    Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
    Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));

    int smallest = slots1.length < slots2.length ? slots1.length : slots2.length;

    int point1 = 0;
    int point2 = 0;
    while (point1 < smallest && point2 < smallest) {
      int[] people1 = slots1[point1];
      int[] people2 = slots1[point2];

      int start = Math.max(people1[0], people2[1]);
      int end = Math.min(people1[1], people2[1]);
      if (end - start >= duration) {
        List<Integer> result = new ArrayList<>();

        result.add(start);
        result.add(start + duration);
        return result;
      }
      if (people1[1] > people2[0]) {
        point2++;
      } else if (people2[1] > people1[0]) {
        point1++;
      }
    }

    return new ArrayList<>();
  }
}
