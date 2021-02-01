package dp_greedy;

public class Num198_HouseRobber {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int max;
    int[] memory = new int[nums.length];

    memory[0] = nums[0];
    memory[1] = nums[1] > nums[0] ? nums[1] : nums[0];
    max = Math.max(memory[0], memory[1]);
    for (int i = 2; i < nums.length; i++) {
      int subMax = Math.max(nums[i] + memory[i - 2], memory[i - 1]);
      max = Math.max(max, subMax);
      memory[i] = subMax;
    }

    return max;
  }
}
