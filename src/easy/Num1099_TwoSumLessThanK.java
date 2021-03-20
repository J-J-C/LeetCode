package easy;

import utils.ListNode;

import java.util.Arrays;

public class Num1099_TwoSumLessThanK {

  public int twoSumLessThanK(int[] nums, int k) {

    int result = -1;
    if (nums.length <= 1) {
      return result;
    }

    Arrays.sort(nums);
    int head = 0;
    int tail = nums.length - 1;
    while (nums[tail] > k) {
      tail--;
    }

    while (head < tail) {
      int sum = nums[head] + nums[tail];
      if (sum >= k) {
        tail--;
      } else {
        result = Math.max(result, sum);
        head++;
      }
    }
    System.out.println("array");
    ListNode node = new ListNode();
    node.next = null;
    node.toString();

    return result;
  }
}
