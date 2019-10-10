package q101_to_q200;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Num198_HouseRobber {

    @Test
    public void testRob1() {
        int[] test1 = {1, 2, 3, 1};
        assertEquals(4, rob(test1));
    }

    @Test
    public void testRob2() {
        int[] test2 = {2, 7, 9, 3, 1};
        assertEquals(12, rob(test2));
    }

    @Test
    public void testRob3() {
        int[] test3 = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        assertEquals(4173, rob(test3));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, memo);
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


    public static int robIterative(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int cur = nums[0], prev = 0, prevPrev = 0;
        for (int i = 1; i < nums.length; i++) {
            prevPrev = prev;
            prev = cur;
            cur = Math.max(nums[i] + prevPrev, prev);
        }
        return cur;
    }
}
