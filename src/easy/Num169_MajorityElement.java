package easy;

public class Num169_MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }

        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (candidate != nums[i]) {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return candidate;
    }
}
