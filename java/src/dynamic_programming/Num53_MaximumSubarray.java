package dynamic_programming;

public class Num53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentOptimal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int subOptimalPrevious = currentOptimal;
            currentOptimal = subOptimalPrevious + nums[i];
            currentOptimal = Math.max(currentOptimal, nums[i]);
            maxSum = Math.max(currentOptimal, maxSum);
        }
        return maxSum;
    }
}
