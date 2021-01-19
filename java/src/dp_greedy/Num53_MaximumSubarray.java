package dp_greedy;

public class Num53_MaximumSubarray {


  // sub_optimal = max(nums[i] + sub_optimal, nums[i])
  // optimal = max(optimal, sub_optimal)

  public int maxSubArray(int[] nums) {
    int optimal = nums[0];
    int subOptimal = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (subOptimal + nums[i] > nums[i]) {
        subOptimal += nums[i];
      } else {
        subOptimal = nums[i];
      }
      optimal = Math.max(subOptimal, optimal);
    }

    return optimal;
  }

  public int maxSubArray2(int[] nums) {
    int n = nums.length;
    int currSum = nums[0], maxSum = nums[0];

    for (int i = 1; i < n; ++i) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}
