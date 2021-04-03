package series.robber;

public class Num231_HouseRobber2 {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length < 2) return nums[0];

    int[] startFromFirstHouse = new int[nums.length + 1];
    int[] startFromSecondHouse = new int[nums.length + 1];

    startFromFirstHouse[0] = 0;
    startFromFirstHouse[1] = nums[0];
    startFromSecondHouse[0] = 0;
    startFromSecondHouse[1] = 0;

    for (int i = 2; i <= nums.length; i++) {
      startFromFirstHouse[i] =
              Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i - 1]);
      startFromSecondHouse[i] =
              Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i - 1]);
    }

    return Math.max(startFromFirstHouse[nums.length - 1], startFromSecondHouse[nums.length]);
  }

  public int rob2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[1], nums[0]);
    }
    int[] memory = new int[nums.length];
    memory[0] = nums[0];
    memory[1] = Math.max(nums[1], nums[0]);

    for (int i = 2; i < memory.length - 1; i++) {
      memory[i] = Math.max(memory[i - 1], memory[i - 2] + nums[i]);
    }

    int[] memory2 = new int[nums.length];
    memory2[1] = nums[1];
    memory2[2] = Math.max(nums[1], nums[2]);

    for (int i = 3; i < memory.length; i++) {
      memory2[i] = Math.max(memory2[i - 1], memory2[i - 2] + nums[i]);
    }

    return Math.max(memory[nums.length - 2], memory2[nums.length - 1]);
  }
}
