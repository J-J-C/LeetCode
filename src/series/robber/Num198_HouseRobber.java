package series.robber;

public class Num198_HouseRobber {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] memory = new int[nums.length];
    memory[0] = nums[0];
    memory[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < memory.length; i++) {
      memory[i] = Math.max(memory[i - 1], memory[i - 2] + nums[i]);
    }

    return memory[nums.length - 1];
  }
}
