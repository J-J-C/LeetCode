package series.stoneweight;

import java.util.HashSet;
import java.util.Set;

public class Num1049_LastStoneWeight2 {

  public static void main(String[] args) {
    //
    int[] nums = {89, 23, 100, 93, 82, 98, 91, 85, 33, 95, 72, 98, 63, 46, 17, 91, 92, 72, 77, 79, 99, 96, 55, 72, 24, 98, 79, 93, 88, 92};
    System.out.println(lastStoneWeightII(nums));
  }

  public static int lastStoneWeightII(int[] stones) {
    // lets handle the base case first
    if (stones.length == 1) {
      return stones[0];
    }
    if (stones.length == 2) {
      return Math.abs(stones[0] - stones[1]);
    }

    int result = Integer.MAX_VALUE;
    Set<Integer> queue = new HashSet<>();

    queue.add(-stones[0]);
    queue.add(stones[0]);

    int counter = 1;
    while (counter < stones.length) {
      int weight = stones[counter];
      Set<Integer> temp = new HashSet<>();
      for (int sum : queue) {
        temp.add(sum + weight);
        temp.add(sum - weight);
      }
      queue = temp;
      counter++;
    }
    for (int i : queue) {
      if (i < 0) {
        continue;
      }
      result = Math.min(result, i);
    }

    return result;
  }


  public int lastStoneWeightII2(int[] stones) {
    int S = 0, S2 = 0;
    for (int s : stones) S += s;
    int n = stones.length;
    boolean[][] dp = new boolean[S + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i] = true;
    }
    for (int i = 1; i <= n; i++) {
      for (int s = 1; s <= S / 2; s++) {
        if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
          dp[s][i] = true;
          S2 = Math.max(S2, s);
        }
      }
    }
    return S - 2 * S2;
  }
}
