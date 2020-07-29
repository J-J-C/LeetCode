package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num539_MinimumTimeDifference {

  public static int minuteDifference(int o1, int o2) {
    return Math.min(Math.abs(o2 - o1), 24 * 60 - (Math.abs(o2 - o1)));
  }

  public int findMinDifference(List<String> timePoints) {
    int min = Integer.MAX_VALUE;
    if (timePoints.size() <= 1) {
      return 0;
    }
    Set<Integer> newList = new HashSet<>();
    for (String time : timePoints) {
      int h1 = Integer.parseInt(time.split(":")[0]);
      int m1 = Integer.parseInt(time.split(":")[1]);
      if (newList.contains(h1 * 60 + m1)) {
        return 0;
      }
      newList.add(h1 * 60 + m1);
    }
    List<Integer> list = new ArrayList<>(newList);
    Collections.sort(list);
    for (int i = 0; i < newList.size() - 1; i++) {
      min = Math.min(min, minuteDifference(list.get(i), list.get(i + 1)));
    }
    return Math.min(min, minuteDifference(list.get(0), list.get(list.size() - 1)));
  }
}
