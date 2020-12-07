package array;

import java.util.Arrays;

public class Num31_NextPermutation {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    //    int[] nums = {1, 3, 2};
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void nextPermutation(int[] nums) {
    // 0. special case
    if (nums.length <= 1) {
      return;
    }

    // 1. find the first pair of (a[i-1], a[i]) from right
    int index = nums.length - 1;
    int previous = index - 1;
    boolean found = false;
    while (previous >= 0) {
      if (nums[index] > nums[previous]) {
        found = true;
        break;
      }
      index--;
      previous--;
    }
    if (!found) {
      reverse(nums, 0);
    } else {
      // 2. trying to find the index x which is bigger than a[i-1]
      int nextLargeIndex = nums.length - 1;
      for (int i = nextLargeIndex; i >= index; i--) {
        if (nums[i] > nums[previous]) {
          nextLargeIndex = i;
          break;
        }
      }

      System.out.println(nums[index]);
      System.out.println(nums[previous]);
      System.out.println(nums[nextLargeIndex]);

      // 3. swap the a[x] with a[i-1]
      swap(nums, previous, nextLargeIndex);
      // 4. revers
      reverse(nums, index);
    }
  }

  private static void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
