package q201_q300;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Num213_HouseRobber2 {

    @Test
    public void testRob1() {
        int[] test1 = {2, 3, 2};
        assertEquals(3, rob(test1));
    }

    @Test
    public void testRob2() {
        int[] test2 = {1, 2, 3, 1};
        assertEquals(4, rob(test2));
    }

    @Test
    public void testRob3() {
        int[] test3 = {1, 2, 1, 1};
        assertEquals(3, rob(test3));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        return Math.max(rob(Arrays.copyOf(nums, nums.length - 1), memo1), rob(Arrays.copyOfRange(nums, 1, nums.length), memo2));
    }

    public static int rob(int[] nums, int[] memo) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (memo[nums.length - 1] != -1) {
            return memo[nums.length - 1];
        }
        memo[nums.length - 1] = Math.max(
                nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length), memo),
                rob(Arrays.copyOfRange(nums, 1, nums.length), memo)
        );
        return memo[nums.length - 1];
    }

}
