package hard;

public class Num72_EditDistance {

  public int minDistance(String word1, String word2) {
    int[][] memory = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < word1.length() + 1; i++) {
      memory[i][0] = i;
    }
    for (int i = 0; i < word2.length() + 1; i++) {
      memory[0][i] = i;
    }

    for (int i = 1; i < word1.length() + 1; i++) {
      for (int j = 1; j < word2.length() + 1; j++) {
        int left = memory[i - 1][j] + 1;
        int down = memory[i][j - 1] + 1;
        int left_down = memory[i - 1][j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          left_down += 1;
        }
        memory[i][j] = Math.min(left, Math.min(down, left_down));
      }
    }

    return memory[word1.length()][word2.length()];
  }
}
