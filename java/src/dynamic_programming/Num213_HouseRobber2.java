package dynamic_programming;

public class Num213_HouseRobber2 {
  public int rob(int[] nums) {
    int currentMax = Integer.MIN_VALUE;
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    return currentMax;
  }
}
