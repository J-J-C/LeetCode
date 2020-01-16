package q001_to_q100;

import java.util.Arrays;

public class Num31_NextPermutation {


    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


        int[] nums1 = {2, 3, 1};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));


        int[] nums2 = {1, 5, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {5, 1, 1};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int pointer = nums.length - 1;
        int previous = pointer - 1;

        int left = -1;
        int right = nums.length - 1;
        while (previous >= 0 && nums[pointer] <= nums[previous]) {
            pointer--;
            previous--;
        }
        left = previous;
        if (left == -1) {
            Arrays.sort(nums);
            return;
        }
        // now we find the right pointer
        for (int i = previous; i < nums.length - 1; i++) {
            if (nums[previous] < nums[i] && nums[previous] >= nums[i + 1]) {
                right = i;
                break;
            }
        }
        swap(nums, right, left);
        Arrays.sort(nums, left + 1, nums.length);
    }

    private static void swap(int[] nums, int pointer, int previous) {
        int temp = nums[pointer];
        nums[pointer] = nums[previous];
        nums[previous] = temp;
    }
}
