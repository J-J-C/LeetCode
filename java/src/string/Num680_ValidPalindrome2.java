package string;

public class Num680_ValidPalindrome2 {

  public static void main(String[] args) {
    String test =
            "aguokepatgbnvfqmgmlcu"
                    + "puufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupu"
                    + "culmgmqfvnbgtapekouga";
    System.out.println(validPalindrome(test));
  }

  public static boolean validPalindrome(String s) {
    boolean didSkip = false;
    if (s.length() <= 2) {
      return true;
    }

    int head = 0;
    int tail = s.length() - 1;
    while (head < tail) {
      if (s.charAt(head) != s.charAt(tail)) {
        return validPalindrome(s, head + 1, tail) || validPalindrome(s, head, tail - 1);
      }
      head++;
      tail--;
    }

    return true;
  }

  private static boolean validPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
