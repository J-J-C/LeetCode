package q001_to_q100;

public class Num35_SearchInsertPosition {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] <= target && target < nums[j]) {
                return j;
            }
        }
        return result;
    }
}
