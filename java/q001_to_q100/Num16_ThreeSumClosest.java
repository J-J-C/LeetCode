package q001_to_q100;

import java.util.*;

public class Num16_ThreeSumClosest {

    public static void main(String[] args) {
        int[] arrays1 = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(arrays1, target));


        int[] arrays2 = {1, 1, 1, 0};
        target = -100;
        System.out.println(threeSumClosest(arrays2, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // return empty if there is no element in the input
        if (nums.length == 0) {
            return 0;
        }

        int closest = Integer.MAX_VALUE;
        int result = 0;


        for (int i = 0; i < nums.length - 2; i++) {
            int value = nums[i];
            int diff = target - value;
            int smallest = twoSumClosest(nums, diff, i);
            System.out.println(String.format("diff: %d, smallest: %d", diff, smallest));
            if (Math.abs(target - (smallest + value)) < closest) {
                result = smallest + value;
                closest = Math.abs(target - (smallest + value));
            }
        }
        return result;
    }

    private static int twoSumClosest(int[] nums, int target, int skipIndex) {
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == skipIndex) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j == skipIndex) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        return result;
    }


    public static int threeSumOptimal(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }

        // sort the array first
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; ++i) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                // we find the exact solution
                if (sum == target) {
                    return sum;
                }
                // if new result is better than current closest, we update the closest
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                // if new sum is smaller than target, left advance (as value increase)
                if (sum < target) {
                    l++;
                }
                // else, we decrease the right side
                else {
                    r++;
                }
            }
        }

        return closest;
    }
}


