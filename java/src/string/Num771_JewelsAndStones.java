package string;

import java.util.HashSet;
import java.util.Set;

public class Num771_JewelsAndStones {

  public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet<>();
    for (char c : J.toCharArray()) {
      set.add(c);
    }
    int counter = 0;
    for (char c : S.toCharArray()) {
      if (set.contains(c)) {
        counter++;
      }
    }
    return counter;
  }
}
