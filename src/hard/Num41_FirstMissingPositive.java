package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Num41_FirstMissingPositive {

    public static void main(String[] args) {
        //
        int[] array = {1, 2, 3, 10, 2147483647, 9};
        System.out.println(firstMissingPositive(array));
    }

    public static int firstMissingPositive(int[] nums) {

        int length = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) {
            return 1;
        }

        // nums = [1]
        if (length == 1) {
            return 2;
        }

        for (int i = 0; i < length; i++) {
            if ((nums[i] <= 0) || (nums[i] > length)) {
                nums[i] = 1;
            }
        }

        // marking as negative to indicate present
        for (int i = 0; i < length; i++) {
            int a = Math.abs(nums[i]);

            if (a == length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return length;
        }

        return length + 1;
    }

    public static int firstMissingPositive2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int largest = 0;
        for (int n : nums) {
            if (n > 0) {
                set.add(n);
                largest = Math.max(largest, n);
            }
        }
        //    System.out.println(largest);
        //    System.out.println(Arrays.toString(set.toArray()));
        for (int i = 1; i < largest; i++) {
            System.out.println(i);
            if (!set.contains(i)) {
                return i;
            }
        }
        return largest + 1;
    }

    public int firstMissingPositiveSorting(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for (int n : nums) {
            if (n < 0) {
                index++;
            } else {
                break;
            }
        }
        if (index == nums.length || nums[index] > 1) {
            return 1;
        }

        for (int i = index; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] == 0) {
                continue;
            } else if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
