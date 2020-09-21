package array;

public class Num287_FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];

        boolean isStart = true;
        while (slowPointer != fastPointer || isStart) {
            isStart = false;

            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
            fastPointer = nums[fastPointer];
        }

        slowPointer = nums[0];
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }
        return slowPointer;
    }
}
