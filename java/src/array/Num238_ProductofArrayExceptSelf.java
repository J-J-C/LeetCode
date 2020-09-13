package array;

public class Num238_ProductofArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    // left array and right array, a good example of partitioning
    if (nums.length == 2) {
      int[] result = {nums[1], nums[0]};
      return result;
    }
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    left[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }

    right[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = left[i] * right[i];
    }
    return result;

  }

  public int[] prductExceptSelfO1Ram(int[] nums) {
    int length = nums.length;

    // Final answer array to be returned
    int[] answer = new int[length];
    answer[0] = 1;

    // left part
    for (int i = 1; i < length; i++) {
      answer[i] = nums[i - 1] * answer[i - 1];
    }

    int R = 1;
    for (int i = length - 1; i >= 0; i--) {
      answer[i] = answer[i] * R;
      R *= nums[i];
    }

    return answer;
  }
}
