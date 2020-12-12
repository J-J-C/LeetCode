package dynamic_programming;

import java.util.Arrays;

public class Num300_LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] array1 = {7, 101, 18};
    int[] array2 = {14, 7, 101, 18};
    int[] array3 = {3, 7, 101, 18};
    int[] array4 = {10, 9, 2, 5, 3, 4};

    //    lengthOfLIS(array1);
    //    lengthOfLIS(array2);
    //    lengthOfLIS(array3);
  }

  public static int lengthOfLIS(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int result = 1;
    int[] memory = new int[nums.length];
    memory[nums.length - 1] = 1;
    memory[nums.length - 2] = 1;
    if (nums[nums.length - 2] < nums[nums.length - 1]) {
      memory[nums.length - 2] = 2;
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      int currentNumber = nums[i];
      memory[i] = 1;
      for (int j = i + 1; j < nums.length; j++) {
        if (currentNumber < nums[j]) {
          memory[i] = Math.max(memory[i], 1 + memory[j]);
        }
      }

      result = Math.max(result, memory[i]);
    }

    return result;
  }

  public int lengthOfLISOptimal(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }
}
