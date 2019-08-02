package q001_to_q100;

public class Num53_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSumEndingHere = nums[0];
        int maxSumSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHere = Math.max(nums[i], maxSumEndingHere + nums[i]);
            maxSumSoFar = Math.max(maxSumEndingHere, maxSumSoFar);
        }

        return maxSumSoFar;
    }
}
