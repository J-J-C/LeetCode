package dp_greedy;

import java.util.Arrays;

public class Num152_MaximumProductSubarray {

  public static void main(String[] args) {
    //
    int[] array = {1, -2, 3, -4, -3, -4, -3};
    System.out.println(Arrays.toString(array));

    System.out.println(maxProduct(array));
  }

  public static int maxProduct(int[] nums) {
    int maxProduct = nums[0];
    int[] memoryMax = new int[nums.length];
    int[] memoryMin = new int[nums.length];

    memoryMax[0] = nums[0];
    memoryMin[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      memoryMin[i] = Math.min(memoryMin[i - 1] * nums[i], nums[i]);
      memoryMin[i] = Math.min(memoryMax[i - 1] * nums[i], memoryMin[i]);

      memoryMax[i] = Math.max(memoryMax[i - 1] * nums[i], nums[i] * memoryMin[i - 1]);
      memoryMax[i] = Math.max(memoryMax[i], nums[i]);

      maxProduct = Math.max(maxProduct, memoryMax[i]);
    }

    return maxProduct;
  }
}
