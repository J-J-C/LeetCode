package q001_to_q100;

import java.util.Arrays;

public class Num26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        int length = removeDuplicates(array);
        System.out.println(length);
        System.out.println(Arrays.toString(Arrays.copyOf(array, length)));
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int total = 1;
        int index = 1;
        int currentValue = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == currentValue) {
                while (i < nums.length && currentValue == nums[i]) {
                    i++;
                }
                if (i == nums.length) {
                    return total;
                }
            }
            currentValue = nums[i];

            nums[index] = nums[i];
            index++;
            total++;
        }
        return total;
    }
}
