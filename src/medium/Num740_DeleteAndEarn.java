package medium;

import java.util.Map;
import java.util.TreeMap;

public class Num740_DeleteAndEarn {

  public int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    int[] keepRecord = new int[map.size()];
    int[] notRecord = new int[map.size()];
    int max = 0;
    Integer[] array = map.keySet().toArray(new Integer[0]);
    keepRecord[0] = array[0] * map.get(array[0]);
    notRecord[0] = 0;
    max = Math.max(keepRecord[0], notRecord[0]);

    if (array.length == 1) {
      return max;
    }

    if (array[1] - array[0] == 1) {
      keepRecord[1] = array[1] * map.get(array[1]);
      notRecord[1] = Math.max(keepRecord[0], notRecord[0]);
    } else {
      keepRecord[1] = array[1] * map.get(array[1]) + keepRecord[0];
      notRecord[1] = Math.max(keepRecord[0], notRecord[0]);
    }

    max = Math.max(keepRecord[1], notRecord[1]);

    for (int i = 2; i < array.length; i++) {
      if (array[i] - array[i - 1] == 1) {
        notRecord[i] = Math.max(keepRecord[i - 1], Math.max(keepRecord[i - 2], notRecord[i - 1]));
        keepRecord[i] =
                Math.max(
                        notRecord[i - 1] + array[i] * map.get(array[i]),
                        keepRecord[i - 2] + +array[i] * map.get(array[i]));
      } else {
        notRecord[i] = Math.max(keepRecord[i - 1], notRecord[i - 1]);
        keepRecord[i] =
                Math.max(
                        notRecord[i - 1] + array[i] * map.get(array[i]),
                        keepRecord[i - 1] + array[i] * map.get(array[i]));
      }

      max = Math.max(max, Math.max(keepRecord[i], notRecord[i]));
    }

    // System.out.println(Arrays.toString(keepRecord));
    // System.out.println(Arrays.toString(notRecord));
    return max;
  }
}
