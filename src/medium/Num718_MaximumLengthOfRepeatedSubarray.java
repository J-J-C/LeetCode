package medium;

public class Num718_MaximumLengthOfRepeatedSubarray {

  public int findLength(int[] A, int[] B) {

    int max = 0;

    int[][] memory = new int[A.length][B.length];

    for (int i = 0; i < A.length; i++) {
      memory[i][0] = A[0] == B[i] ? 1 : 0;
    }

    for (int i = 0; i < B.length; i++) {
      memory[0][i] = A[i] == B[0] ? 1 : 0;
    }

    for (int i = 1; i < A.length; i++) {
      for (int j = 1; j < B.length; j++) {
        memory[i][j] = A[j] == B[i] ? memory[i - 1][j - 1] + 1 : 0;
        max = Math.max(memory[i][j], max);
      }
    }
    return max;
  }
}
