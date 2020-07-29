package array;

public class Num704_BinarySearch {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    int mid = left + (right - left) / 2;
    while (left < right) {
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
      mid = left + (right - left) / 2;
    }
    return -1;
  }
}
