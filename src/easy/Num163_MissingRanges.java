package easy;

import java.util.ArrayList;
import java.util.List;

public class Num163_MissingRanges {

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    String arrow = "->";
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      if (upper == lower) {
        result.add("" + lower);
        return result;
      } else {
        result.add(lower + arrow + upper);
        return result;
      }
    }

    // handle head
    int diff = nums[0] - lower;
    if (diff == 1) {
      result.add("" + (lower));
    } else if (diff > 1) {
      result.add((lower) + arrow + (nums[0] - 1));
    }

    for (int i = 0; i < nums.length - 1; i++) {
      diff = nums[i + 1] - nums[i];
      if (diff == 2) {
        result.add("" + (nums[i] + 1));
      } else if (diff > 2) {
        result.add((nums[i] + 1) + arrow + (nums[i + 1] - 1));
      }
    }

    // handle tail
    diff = upper - nums[nums.length - 1];
    if (diff == 1) {
      result.add("" + (upper));

    } else if (diff > 1) {
      result.add((nums[nums.length - 1] + 1) + arrow + (upper));
    }

    return result;
  }
}
