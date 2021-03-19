package easy;

import java.util.ArrayList;
import java.util.List;

public class Num1213_IntersectionOfThreeSortedArrays {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> result = new ArrayList<>();

    int ptr1 = 0;
    int ptr2 = 0;
    int ptr3 = 0;

    while (ptr1 < arr1.length && ptr2 < arr2.length && ptr3 < arr3.length) {
      // avoid index out of bounds error
      if (arr1[ptr1] == arr2[ptr2] && arr2[ptr2] == arr3[ptr3]) {
        result.add(arr1[ptr1]);
        ptr1++;
        ptr2++;
        ptr3++;
      } else {
        if (arr1[ptr1] < arr2[ptr2]) {
          ptr1++;
        } else if (arr2[ptr2] < arr3[ptr3]) {
          ptr2++;
        } else {
          ptr3++;
        }
      }
    }

    return result;
  }
}
