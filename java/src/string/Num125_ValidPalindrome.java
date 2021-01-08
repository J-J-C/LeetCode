package string;

public class Num125_ValidPalindrome {

  public boolean isPalindrome(String s) {
    if (s.length() == 0) return true;
    String s1 = s.toLowerCase();
    int head = 0;
    int tail = s.length() - 1;

    char h;
    char t;
    while (head < tail) {
      h = s1.charAt(head);
      t = s1.charAt(tail);

      while (!Character.isLetterOrDigit(h)) {
        head++;
        if (head >= s.length()) {
          return true;
        }
        h = s1.charAt(head);
      }

      while (!Character.isLetterOrDigit(t)) {
        tail--;
        t = s1.charAt(tail);
      }
      if (h != t) {
        return false;
      }
      head++;
      tail--;
    }
    return true;
  }
}
