package medium;

import java.util.PriorityQueue;

public class Num215_KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int number = nums[i];
      if (pq.size() < k) {
        pq.add(number);
        continue;
      }
      if (nums[i] > pq.peek()) {
        pq.poll();
        pq.add(number);
      }
    }

    return pq.peek();
  }
}
