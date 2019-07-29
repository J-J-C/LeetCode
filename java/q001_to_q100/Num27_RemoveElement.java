package q001_to_q100;

import java.util.Arrays;

public class Num27_RemoveElement {


    public static void main(String[] args) {
        int[] array = {3, 2, 2, 3};
        int val = 3;
        int length = removeElement(array, val);
        System.out.println(length);
        System.out.println(Arrays.toString(Arrays.copyOf(array, length)));
    }

    public static int removeElement(int[] nums, int val) {
        int total = nums.length;
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (nums[index] == val && (index != i)) {
                    index--;
                    total--;
                    if(total == 0) {
                        return 0;
                    }
                }
                nums[i] = nums[index];
                nums[index] = val;
                index--;
                total--;
            }
            if (index <= i) {
                break;
            }
        }
        return total;
    }
}
