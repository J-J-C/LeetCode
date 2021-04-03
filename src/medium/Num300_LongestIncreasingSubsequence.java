package medium;

public class Num300_LongestIncreasingSubsequence {

  public static void main(String[] args) {
    //
    int[] array = {1, 3, 6, 7, 9, 4, 10, 5, 6};
    System.out.println(lengthOfLIS(array));
  }

  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] memory = new int[nums.length];
    memory[0] = 1;
    int totalMax = 1;
    for (int i = 1; i < nums.length; i++) {
      int currentMax = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          currentMax = Math.max(currentMax, memory[j]);
        }
      }
      currentMax += 1;
      memory[i] = currentMax;
      totalMax = Math.max(totalMax, currentMax);
    }
    return totalMax;
  }
}
