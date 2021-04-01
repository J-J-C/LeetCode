package hard;

public class Num4_MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    // step 1: always have nums1 as shorter array
    int num1Length = nums1.length;
    int num2Length = nums2.length;

    if (num1Length > num2Length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    // step 2, define cut start and cut end
    int num1Start = 0;
    int num1End = num1Length;
    int fullArrayLength = num1Length + num2Length;

    while (num1Start <= num1End) {

      // step 3: make the cut, do the evaluation
      int num1Cut = (num1Start + num1End) / 2;
      int num2Cut = (fullArrayLength + 1) / 2 - num1Cut;

      double l1 = num1Cut == 0 ? Integer.MIN_VALUE : nums1[num1Cut - 1];
      double l2 = num2Cut == 0 ? Integer.MIN_VALUE : nums2[num2Cut - 1];
      double r1 = num1Cut == num1Length ? Integer.MAX_VALUE : nums1[num1Cut];
      double r2 = num2Cut == num2Length ? Integer.MAX_VALUE : nums2[num2Cut];

      if (l1 > r2) {
        num1End = num1Cut - 1;
      } else if (l2 > r1) {
        num1Start = num1Cut + 1;
      } else {
        if (fullArrayLength % 2 == 0) {
          return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        } else {
          return Math.max(l1, l2);
        }
      }
    }

    return -1;
  }
}
