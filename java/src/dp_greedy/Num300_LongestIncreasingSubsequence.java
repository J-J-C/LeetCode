package dp_greedy;

public class Num300_LongestIncreasingSubsequence {

  public static int lengthOfLIS(int[] nums) {
    int maximum = 1;
    int[] memory = new int[nums.length];
    memory[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      int currentMax = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          currentMax = Math.max(currentMax, memory[j]);
        }
      }
      memory[i] = currentMax + 1;
      maximum = Math.max(maximum, memory[i]);
    }

    return maximum;
  }
}
