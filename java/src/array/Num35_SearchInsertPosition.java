package array;

public class Num35_SearchInsertPosition {

  public static void main(String[] args) {
    int[] array = {1, 3, 5, 6};
    int target = 7;
    System.out.println(searchInsert(array, target));
  }

  public static int searchInsert(int[] nums, int target) {
    return searchInsert(nums, target, 0, nums.length - 1);
  }

  private static int searchInsert(int[] nums, int target, int left, int right) {
    if (left == right) {
      return nums[left] >= target ? 0 : nums.length;
    }

    int mid = (left + right) / 2;

    if (target < nums[mid]) {
      return searchInsert(nums, target, left, mid);
    } else if (target > nums[mid + 1]) {
      return searchInsert(nums, target, mid + 1, right);
    } else if (nums[mid] <= target && nums[mid + 1] >= target) {
      if (nums[mid] == target) {
        return mid;
      } else {
        return mid + 1;
      }
    } else {
      return -1;
    }
  }
}
