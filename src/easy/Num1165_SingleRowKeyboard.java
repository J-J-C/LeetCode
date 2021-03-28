package easy;

import java.util.HashMap;
import java.util.Map;

public class Num1165_SingleRowKeyboard {

  public int calculateTime(String keyboard, String word) {
    int total = 0;
    int previous = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < keyboard.length(); i++) {
      map.put(keyboard.charAt(i), i);
    }

    for (char c : word.toCharArray()) {

      int index = map.get(c);
      total += Math.abs(index - previous);
      previous = index;
    }

    return total;
  }
}
