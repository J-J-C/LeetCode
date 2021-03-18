package easy;

import java.util.Arrays;

public class Num1710_MaximumUnitsOnATruck {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (o1, o2) -> -(o1[1] - o2[1]));
    int count = 0;
    for (int[] box : boxTypes) {
      int boxCount = box[0];
      int itemPerBox = box[1];
      if (boxCount < truckSize) {
        count += boxCount * itemPerBox;
      } else {
        count += truckSize * itemPerBox;
        return count;
      }
      truckSize -= boxCount;
    }
    return count;
  }
}
