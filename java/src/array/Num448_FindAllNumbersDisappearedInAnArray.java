package array;

import java.util.ArrayList;
import java.util.List;

public class Num448_FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();

    int[] memory = new int[nums.length + 1];
    for (int i : nums) {
      memory[i]++;
    }
    for (int i = 1; i < memory.length; i++) {
      if (memory[i] == 0) {
        result.add(i);
      }
    }
    return result;
  }
}
