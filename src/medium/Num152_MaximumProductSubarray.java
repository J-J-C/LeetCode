package medium;

import java.util.Arrays;

public class Num152_MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int[] toMultiplyPositive = new int[nums.length];
    int[] toMultiplyNegative = new int[nums.length];
    int[] notMultiply = new int[nums.length];

    toMultiplyPositive[0] = nums[0] > 0 ? nums[0] : 1;
    toMultiplyNegative[0] = nums[0] < 0 ? nums[0] : 1;
    notMultiply[0] = 1;
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      toMultiplyPositive[i] =
              Math.max(toMultiplyPositive[i - 1] * nums[i], toMultiplyNegative[i - 1] * nums[i]);
      toMultiplyPositive[i] = Math.max(toMultiplyPositive[i], 0);
      toMultiplyPositive[i] = Math.max(toMultiplyPositive[i], nums[i]);

      toMultiplyNegative[i] =
              Math.min(toMultiplyPositive[i - 1] * nums[i], toMultiplyNegative[i - 1] * nums[i]);
      toMultiplyNegative[i] = Math.min(toMultiplyNegative[i], 0);
      toMultiplyNegative[i] = Math.min(toMultiplyNegative[i], nums[i]);

      max = Math.max(max, toMultiplyPositive[i]);
      max = Math.max(max, toMultiplyNegative[i]);
    }

    System.out.println(Arrays.toString(toMultiplyPositive));
    System.out.println(Arrays.toString(toMultiplyNegative));
    return max;
  }

  public int maxProduct2(int[] nums) {

    int toMultiplyPositive = nums[0] > 0 ? nums[0] : 0;
    int toMultiplyNegative = nums[0] < 0 ? nums[0] : 0;
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int previousPositive = toMultiplyPositive;
      toMultiplyPositive = Math.max(toMultiplyPositive * nums[i], toMultiplyNegative * nums[i]);
      toMultiplyPositive = Math.max(toMultiplyPositive, nums[i]);

      toMultiplyNegative = Math.min(previousPositive * nums[i], toMultiplyNegative * nums[i]);
      toMultiplyNegative = Math.min(toMultiplyNegative, nums[i]);

      max = Math.max(max, toMultiplyPositive);
      max = Math.max(max, toMultiplyNegative);
    }

    return max;
  }
}
