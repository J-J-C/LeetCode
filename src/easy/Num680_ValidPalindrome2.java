package easy;

public class Num680_ValidPalindrome2 {

  public boolean isPalindromeRange(String s, int head, int tail) {
    for (int k = head; k <= head + (tail - head) / 2; k++) {
      if (s.charAt(k) != s.charAt(tail - k + head)) {
        return false;
      }
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    for (int head = 0; head < s.length() / 2; head++) {
      int tail = s.length() - 1 - head;
      if (s.charAt(head) != s.charAt(tail)) {
        return (isPalindromeRange(s, head + 1, tail) || isPalindromeRange(s, head, tail - 1));
      }
    }
    return true;
  }
}
