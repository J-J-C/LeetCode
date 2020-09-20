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

  public void sortColorsOptimal(int[] nums) {
    // for all idx < i : nums[idx < i] = 0
    // j is an index of element under consideration
    int p0 = 0, curr = 0;
    // for all idx > k : nums[idx > k] = 2
    int p2 = nums.length - 1;

    int tmp;
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // swap p0-th and curr-th elements
        // i++ and j++
        tmp = nums[p0];
        nums[p0++] = nums[curr];
        nums[curr++] = tmp;
      } else if (nums[curr] == 2) {
        // swap k-th and curr-th elements
        // p2--
        tmp = nums[curr];
        nums[curr] = nums[p2];
        nums[p2--] = tmp;
      } else {
        curr++;
      }
    }
  }
}
