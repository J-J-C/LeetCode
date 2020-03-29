package q201_q300;

import java.util.Arrays;

public class Num283_MoveZeroes {


    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);

        System.out.println(Arrays.toString(array));


        int[] array2 = {1, 41, 0, 3, 10, 0, 12, 5, 6, 9, 23, 0, 4};
        moveZeroesOptimal(array2);

        System.out.println(Arrays.toString(array2));
    }

    public static void moveZeroes(int[] nums) {
        // base case
        if (nums.length <= 1) {
            return;
        }

        int pointer = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pointer < nums.length && nums[pointer] != 0) {
                pointer++;
            }
            int mem = pointer;
            if (pointer == nums.length) {
                break;
            }
            int next = pointer + 1;
            System.out.println(Arrays.toString(nums));
            System.out.println(next);
            while (nums[next] != 0) {
                nums[pointer] = nums[next];
                nums[next] = 0;
                pointer = next;
                next++;
            }
            int nextNot0 = next + 1;

            while (nextNot0 < nums.length && nums[nextNot0] == 0) {
                nextNot0++;
            }
            if (nextNot0 >= nums.length) {
                break;
            }
            nums[pointer] = nums[nextNot0];
            nums[nextNot0] = 0;

            pointer = next;
            i = pointer - 1;
        }
    }

    public static void moveZeroesOptimal(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
