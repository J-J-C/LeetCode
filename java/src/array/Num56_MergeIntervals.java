package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num56_MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
      return intervals;
    }
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> result = new ArrayList<>();

    int[] temp = new int[2];
    temp[0] = intervals[0][0];
    temp[1] = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int[] first = intervals[i];
      if (first[0] <= temp[1]) {
        temp[1] = temp[1] > first[1] ? temp[1] : first[1];
        continue;
      } else {
        int[] tempResult = new int[2];
        tempResult[0] = temp[0];
        tempResult[1] = temp[1];
        result.add(tempResult);
        temp[0] = first[0];
        temp[1] = first[1];
      }
    }
    result.add(temp);
    int[][] finalResult = new int[result.size()][2];
    int index = 0;
    for (int[] i : result) {
      finalResult[index][0] = i[0];
      finalResult[index][1] = i[1];
      index++;
    }
    return finalResult;
  }
}



