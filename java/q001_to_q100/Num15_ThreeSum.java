package q001_to_q100;

import java.util.*;

public class Num15_ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                }
                int desired = 0 - nums[i] - nums[j];
                if(map.containsKey(desired)) {
                    List<Integer> list = Arrays.asList(nums[i], desired, nums[j]);
                    String key = generateKey(nums[i], desired, nums[j]);
                    resultMap.put(key, list);
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
            map.clear();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(resultMap.values());
        return resultList;
    }

    private String generateKey(int num, int desired, int num1) {
        int min = Math.min(num, Math.min(desired, num1));
        if(min == num) {
            return "" + num + Math.min(desired, num1) + Math.max(desired, num1);
        }
        else if(min == desired) {
            return "" + desired + Math.min(num, num1) + Math.max(num, num1);

        } else {
            return "" + num1 + Math.min(desired, num) + Math.max(desired, num);
        }
    }
}


