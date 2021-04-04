package medium;

import java.util.*;

public class Num56_MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    Stack<int[]> stack = new Stack<>();
    stack.push(intervals[0]);
    List<int[]> result = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] <= stack.peek()[1]) {
        if (interval[1] > stack.peek()[1]) {
          stack.peek()[1] = interval[1];
        }
      } else {
        if (interval[1] > stack.peek()[1]) {
          result.add(stack.pop());
          stack.push(interval);
        }
      }
    }
    result.add(stack.pop());
    int[][] finalResult = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      finalResult[i] = result.get(i);
    }
    return finalResult;
  }
}
