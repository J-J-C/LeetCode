package easy;

import java.util.Arrays;

public class Num1180_CountSubstringsWithOnlyOneDistinctLetter {
  public int countLetters(String s) {
    int[] countMap = new int[s.length()];
    countMap[0] = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        countMap[i] = countMap[i - 1] + 1;
      } else {
        countMap[i] = 1;
      }
    }
    return Arrays.stream(countMap).sum();
  }

  public int countLetters2(String s) {
    int total = 1;
    int counter = 1;
    for (int i = 1; i < s.length(); i++) {
      counter = s.charAt(i - 1) == s.charAt(i) ? counter + 1 : 1;
      total += counter;
    }
    return total;
  }
}
