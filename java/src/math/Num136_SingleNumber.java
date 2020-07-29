package math;

public class Num136_SingleNumber {

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i : nums) {
      result = result ^ i;
    }
    return result;
  }
}
