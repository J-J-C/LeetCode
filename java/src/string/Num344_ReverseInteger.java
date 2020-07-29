package string;

public class Num344_ReverseInteger {

  public void reverseString(char[] s) {
    int head = 0;
    int tail = s.length - 1;
    while (head < tail) {
      char temp = s[head];
      s[head] = s[tail];
      s[tail] = temp;
      head++;
      tail--;
    }
  }
}
