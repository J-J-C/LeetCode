package q001_to_q100;

import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length < 2) {
            return array;
        }

        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int reminder = target - nums[i];
            if (map.containsKey(reminder)) {
                array[0] = map.get(reminder);
                array[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return array;
    }
}
