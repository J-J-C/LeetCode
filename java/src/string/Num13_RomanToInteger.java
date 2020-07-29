package string;

import java.util.HashMap;
import java.util.Map;

public class Num13_RomanToInteger {


  public int romanToInt(String s) {
    int value = 0;

    // construct map
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int currentPointer = 0;
    while (currentPointer < s.length()) {
      char current = s.charAt(currentPointer);
      value = value + map.get(current);
      if (currentPointer > 0) {
        char previous = s.charAt(currentPointer - 1);

        if (map.get(previous) < map.get(current)) {
          value = value - map.get(previous) * 2;
        }
      }
      currentPointer++;
    }
    return value;
  }
}
