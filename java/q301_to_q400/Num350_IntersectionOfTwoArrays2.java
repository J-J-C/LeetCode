package q301_to_q400;

import java.util.*;

public class Num350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i:nums2) {
            if(map.containsKey(i)) {
                int count = map.get(i);
                list.add(i);
                count--;
                if(count == 0) {
                    map.remove(i);
                } else {
                    map.put(i, count);
                }
            }
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
