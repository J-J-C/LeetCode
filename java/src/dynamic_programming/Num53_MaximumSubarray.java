package dynamic_programming;

public class Num53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int oldSum = currentSum;
            currentSum = oldSum + value;
            currentSum = Math.max(currentSum, value);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
