package q1000_and_after;

import java.util.*;


public class Num1122_RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] sorted = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int index = 0;
        for (int num : arr2) {
            int appearance = map.get(num);
            while(appearance > 0) {
                sorted[index] = num;
                appearance--;
                index++;
            }
            map.remove(num);
        }
        int[] remaining = map.keySet().stream().mapToInt(i->i).toArray();
        Arrays.sort(remaining);
        for(int num: remaining) {
            int appearance = map.get(num);
            while(appearance > 0) {
                sorted[index] = num;
                appearance--;
                index++;
            }
        }
        return sorted;
    }


    public static int[] relativeSortArrayImproved(int[] arr1, int[] arr2) {
        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];

        int[] result = new int[arr1.length];
        int index = 0;

        // Fill bucket
        for(int i : arr1) {
            bucket[i]++;
        }

        // First store result in order of arr2
        for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }

        // Fill remaining element
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }
}
