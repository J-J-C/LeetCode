package medium;

import utils.NestedInteger;

import java.util.List;

public class Num339_NestedListWeightSum {

  public int depthSum(List<NestedInteger> nestedList) {
    int sum = 0;
    for (NestedInteger value : nestedList) {
      sum += depthSum(value, 1);
    }
    return sum;
  }

  public int depthSum(NestedInteger integer, int level) {
    int value = 0;
    if (integer.isInteger()) {
      value = integer.getInteger() * level;
    } else {
      for (NestedInteger number : integer.getList()) {
        value += depthSum(number, level + 1);
      }
    }
    return value;
  }
}
