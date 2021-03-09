package array;

public class Num238_ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {

    int[] leftToRight = new int[nums.length];
    int[] rightToLeft = new int[nums.length];

    int sum = 1;
    for (int i = 0; i < nums.length; i++) {
      sum *= nums[i];
      leftToRight[i] = sum;
    }

    sum = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum *= nums[i];
      rightToLeft[i] = sum;
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        result[i] = rightToLeft[1];
      } else if (i == nums.length - 1) {
        result[i] = leftToRight[i - 1];
      } else {
        result[i] = leftToRight[i - 1] * rightToLeft[i + 1];
      }
    }
    return result;
  }
}
