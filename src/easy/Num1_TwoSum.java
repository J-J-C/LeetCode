package easy;

import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            if (map.containsKey(remains)) {
                result[0] = i;
                result[1] = map.get(remains);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
