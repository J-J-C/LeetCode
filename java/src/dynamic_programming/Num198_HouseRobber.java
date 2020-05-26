package dynamic_programming;

public class Num198_HouseRobber {
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
        currentMax = Math.max(nums[0], nums[1]);
        int[] memory = new int[nums.length];
        memory[0] = nums[0];
        memory[1] = currentMax;
        for (int i = 2; i < nums.length; i++) {
            int subOptimal = Math.max(memory[i - 2] + nums[i], memory[i - 1]);
            currentMax = Math.max(subOptimal, currentMax);
            memory[i] = subOptimal;
        }
        return currentMax;
    }
}
