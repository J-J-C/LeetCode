package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingElements {

    public static void main(String[] args) {
        int[] array = {3, 1, 5, 3, 7, 0, 5};
        System.out.println(countElements(array));
    }

    public static int countElements(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int target = arr[i] + 1;
            if (Arrays.binarySearch(arr, target) >= i + 1) {
                result.add(i);
            }
        }
        return result.size();
    }

    public static int countElementsUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int result = 0;
        for (int i : arr) {
            if (set.contains(i + 1)) {
                result++;
            }
        }
        return result;
    }

}
