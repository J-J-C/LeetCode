package array;

import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if(map.containsKey(remaining)) {
                solution[0] = i;
                solution[1] = map.get(remaining);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return solution;
    }
}
