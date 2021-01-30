package dp_greedy;

public class Num5_LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    int start = 0;
    int end = 0;
    int[][] memory = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (j - i < end - start) {
          continue;
        }
        if (isPalindromic(s, i, j, memory) == 2) {
          if (end - start < j - i) {
            start = i;
            end = j;
          }
        }
      }
    }
    return s.substring(start, end + 1);
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

  public String longestPalindromeExpandAroundCenter(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }
}
