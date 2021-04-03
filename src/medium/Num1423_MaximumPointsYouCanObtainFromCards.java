package medium;

import java.util.Arrays;

public class Num1423_MaximumPointsYouCanObtainFromCards {

  public static void main(String[] args) {
    //
    int[] array = {1, 79, 80, 1, 1, 1, 200, 1};
    int k = 3;
    System.out.println(maxScore(array, k));
  }

  public static int maxScore(int[] cardPoints, int k) {
    if (k == cardPoints.length) {
      return Arrays.stream(cardPoints).sum();
    }
    int leftSum = 0;
    for (int i = 0; i < k; ++i) {
      leftSum += cardPoints[i];
    }
    int max = leftSum;
    for (int rightSum = 0, i = 0; i < k; ++i) {
      rightSum += cardPoints[cardPoints.length - 1 - i];
      leftSum -= cardPoints[k - 1 - i];
      max = Math.max(max, leftSum + rightSum);
    }
    return max;
  }
}
