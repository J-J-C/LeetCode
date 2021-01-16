package dp;

public class Num746_MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    int[] memory = new int[cost.length + 1];

    if (cost.length == 1) {
      return cost[0];
    }
    if (cost.length == 2) {
      return cost[1];
    }

    memory[0] = cost[0];
    memory[1] = cost[1];
    int i = 2;
    while (i != memory.length) {

      if (i == memory.length - 1) {
        memory[i] = Math.min(memory[i - 1], memory[i - 2]);
      } else {
        memory[i] = Math.min(memory[i - 1] + cost[i], memory[i - 2] + cost[i]);
      }
      i++;
    }
    return memory[cost.length];
  }
}
