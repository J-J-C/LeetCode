package easy;

import java.util.*;

public class Num1133_LargestUniqueNumber {
  public static void main(String[] args) {
    int[] array = {5, 7, 3, 9, 4, 9, 8, 3, 1};

    System.out.println(largestUniqueNumber2(array));
  }

  public static int largestUniqueNumber(int[] A) {
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int a : A) {
      if (!set.contains(a)) {
        set.add(a);
        priorityQueue.add(a);
      } else {
        while (!priorityQueue.isEmpty() && priorityQueue.peek() == a) {
          priorityQueue.poll();
        }
      }

      System.out.println(Arrays.toString(priorityQueue.toArray()));
    }

    return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
  }

  public static int largestUniqueNumber2(int[] A) {
    Arrays.sort(A);
    Set<Integer> set = new HashSet<>();
    set.add(A[A.length - 1]);
    for (int i = A.length - 2; i > 0; i--) {

      System.out.println(A[i]);
      System.out.println(Arrays.toString(set.toArray()));

      if (!set.contains(A[i])) {
        return A[i + 1];
      } else {
        int value = A[i];
        while (i >= 0 && A[i] == value) {
          i--;
        }
        set.clear();
        if (i < 0) {
          return -1;
        }
        set.add(A[i]);
      }
    }
    return set.isEmpty() ? -1 : (int) set.toArray()[0];
  }

  public int largestUniqueNumber3(int[] A) {
    // Sort in ascending order.
    Arrays.sort(A);

    for (int i = A.length - 1; i >= 0; i--) {
      // If there is no duplicate return.
      if (i == 0 || A[i] != A[i - 1]) return A[i];

      // While duplicates exist.
      while (i > 0 && A[i] == A[i - 1]) {
        i--;
      }
    }
    return -1;
  }

  public int largestUniqueNumber4(int[] A) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    // Store counts of each element
    for (int i : A) {
      count.put(i, count.getOrDefault(i, 0) + 1);
    }
    int result = -1;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      // If count of the integer is 1 get maximum.
      if (entry.getValue() == 1) {
        result = Math.max(result, entry.getKey());
      }
    }
    return result;
  }
}
