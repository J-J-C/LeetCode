package dynamic_programming;

public class Num5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "tattarrattat";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int palindromeStartsAt = 0;
        int maxLength = 0;

        boolean[][] memory = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                memory[i][j] = (s.charAt(i) == s.charAt(j))
                        && (j - i < 3 || memory[i + 1][j - 1]);

                if (memory[i][j] && (j - i + 1 > maxLength)) {
                    palindromeStartsAt = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLength);
    }

    public String longestPalindrome2(String s) {
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
