package array;

public class Num75_SortColors {

  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length - 1;

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num == 1) {
        continue;
      }
      while ((num == 0 || num == 2) && zeroIndex < twoIndex) {
        if (num == 0 && i >= zeroIndex) {
          int temp = nums[zeroIndex];
          nums[i] = temp;
          nums[zeroIndex] = num;
          num = nums[i];
          zeroIndex++;
        } else if (num == 2 && i <= twoIndex) {
          int temp = nums[twoIndex];
          nums[i] = temp;
          nums[twoIndex] = num;
          num = nums[i];
          twoIndex--;
        } else {
          break;
        }
      }
    }
  }
}
