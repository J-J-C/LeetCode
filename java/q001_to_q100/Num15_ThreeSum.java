package q001_to_q100;

import java.util.*;

public class Num15_ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int desired = 0 - nums[i] - nums[j];
                if (map.containsKey(desired)) {
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
        if (min == num) {
            return "" + num + Math.min(desired, num1) + Math.max(desired, num1);
        } else if (min == desired) {
            return "" + desired + Math.min(num, num1) + Math.max(num, num1);

        } else {
            return "" + num1 + Math.min(desired, num) + Math.max(desired, num);
        }
    }


    public List<List<Integer>> threeSumOptimal(int[] nums) {
        // return empty if there is no element in the input
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        // sort the input array
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        int arrayLength = nums.length;
        for (int k = 0; k < arrayLength - 2; k++) {
            // if two numbers are identical, skip
            while (k > 0 && k < arrayLength - 2 && nums[k] == nums[k - 1]) {
                k++;
            }
            // we stopped either k reaches the end or k is > 0
            if (k >= arrayLength - 2 || nums[k] > 0) {
                break;
            }


            int i = k + 1;
            int j = nums.length - 1;
            // for such k, we find all paired i and j
            while (i < j) {
                if (nums[i] + nums[j] == -nums[k]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }

                    i++;
                    j--;
                } else if (nums[i] + nums[j] > -nums[k]) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}


