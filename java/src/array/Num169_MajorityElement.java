package array;

public class Num169_MajorityElement {

  public int majorityElement(int[] nums) {
    int count = 0, result = 0;
    for (int num : nums) {
      if (count == 0) {
        result = num;
      }
      if (num != result) {
        count--;
      } else {
        count++;
      }
    }
    return result;
  }
}
