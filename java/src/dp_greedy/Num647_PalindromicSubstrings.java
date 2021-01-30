package dp_greedy;

public class Num647_PalindromicSubstrings {

  public static int countSubstrings(String s) {
    int count = 0;
    int[][] memory = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPalindromic(s, i, j, memory) == 2) {
          count++;
        }
      }
    }
    return count;
  }

  public static int isPalindromic(String s, int start, int end, int[][] memory) {
    if (memory[start][end] != 0) {
      return memory[start][end];
    }
    if (start < 0 || end >= s.length()) {
      return 1;
    }
    if (start == end || start > end) {
      memory[start][end] = 2;
      return 2;
    }
    if (s.charAt(start) != s.charAt(end)) {
      memory[start][end] = 1;
      return 1;
    } else {
      int result = isPalindromic(s, start + 1, end - 1, memory);
      memory[start][end] = result;
      return result;
    }
  }

  public int countSubstringsDP(String s) {
    int n = s.length(), ans = 0;

    if (n <= 0) return 0;

    boolean[][] dp = new boolean[n][n];

    // Base case: single letter substrings
    for (int i = 0; i < n; ++i, ++ans) dp[i][i] = true;

    // Base case: double letter substrings
    for (int i = 0; i < n - 1; ++i) {
      dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
      ans += (dp[i][i + 1] ? 1 : 0);
    }

    // All other cases: substrings of length 3 to n
    for (int len = 3; len <= n; ++len)
      for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
        dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
        ans += (dp[i][j] ? 1 : 0);
      }

    return ans;
  }
}
