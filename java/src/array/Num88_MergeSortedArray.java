package array;

public class Num88_MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = nums1.length - 1;
    m--;
    n--;
    while (m >= 0 && n >= 0) {
      if (nums1[m] >= nums2[n]) {
        nums1[index] = nums1[m];
        m--;
      } else {
        nums1[index] = nums2[n];
        n--;
      }
      index--;
    }
    while (m >= 0) {
      nums1[index] = nums1[m];
      m--;
      index--;
    }
    while (n >= 0) {
      nums1[index] = nums2[n];
      n--;
      index--;
    }
  }
}
