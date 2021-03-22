package series.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num170_TwoSum3_DataStructureDesign {
}

class TwoSum {

  Map<Integer, Integer> numberMap = new HashMap<>();
  Set<Integer> sumSet = new HashSet<>();

  public TwoSum() {
  }

  public void add(int number) {
    numberMap.put(number, numberMap.getOrDefault(number, 0) + 1);
  }

  public boolean find(int value) {

    if (sumSet.contains(value)) {
      return true;
    } else {
      boolean found = false;
      for (int i : numberMap.keySet()) {
        if (numberMap.containsKey(value - i)) {
          if (value - i == i && numberMap.get(i) == 1) {
          } else {
            sumSet.add(value);
            return true;
          }
        }
      }
      return false;
    }
  }
}
