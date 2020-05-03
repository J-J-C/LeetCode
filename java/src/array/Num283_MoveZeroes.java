package array;

import java.util.Arrays;

public class Num283_MoveZeroes {

    public static void main(String[] args) {
        int[] array = {1, 0, 3, 12};
        moveZeroes(array);

        int[] array2 = {0, 1, 0, 3, 12};
        moveZeroes(array2);
    }

    public static void moveZeroes(int[] nums) {
        int pointer = 0;
        int zeroIndex = 0;
        while (pointer < nums.length) {
            if (nums[pointer] != 0) {
                int temp = nums[pointer];
                nums[pointer] = nums[zeroIndex];
                nums[zeroIndex] = temp;

                pointer++;
                zeroIndex++;
            } else {
                pointer++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
