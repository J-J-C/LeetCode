package medium;

public class Num1328_BreakAPalindrome {
  public String breakPalindrome(String palindrome) {
    if (palindrome.length() == 1) {
      return "";
    }
    char[] array = palindrome.toCharArray();
    int head = 0;
    int tail = palindrome.length() - 1;
    while (head < tail) {
      if (array[head] != 'a') {
        array[head] = 'a';
        return String.valueOf(array);
      } else {
        head++;
        tail--;
      }
    }
    array[palindrome.length() - 1] = 'b';
    return String.valueOf(array);
  }

  public String breakPalindrome2(String palindrome) {
    char[] s = palindrome.toCharArray();
    int n = s.length;

    for (int i = 0; i < n / 2; i++) {
      if (s[i] != 'a') {
        s[i] = 'a';
        return String.valueOf(s);
      }
    }
    s[n - 1] = 'b'; //if all 'a'
    return n < 2 ? "" : String.valueOf(s);
  }
}
