package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Num41_FirstMissingPositive {
  public int firstMissingPositiveUsingSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (num > 0) {
        set.add(num);
      }
    }
    int i = 1;
    while (set.contains(i)) {
      i++;
    }
    return i;
  }

  public int firstMissingPositiveOptimal(int[] nums) {
    int length = nums.length;
    int[] map = new int[length + 1];

    Arrays.fill(map, 0);
    boolean isOnePresent = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        isOnePresent = true;
      }
      if (nums[i] < 0 || nums[i] > length) {
        nums[i] = 1;
      }
    }
    if (!isOnePresent) {
      return 1;
    }

    for (int i = 0; i < nums.length; i++) {
      if (map[nums[i]] == 0) {
        map[nums[i]] = 1;
      }
    }
    for (int i = 1; i < map.length; i++) {
      if (map[i] == 0) {
        return i;
      }
    }
    return map.length;
  }
}
