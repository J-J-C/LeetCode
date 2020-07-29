package dynamic_programming;

public class Num70_ClimbingStairs {

  public int climbStairs(int n) {
    if (n < 3) {
      return n;
    }
    int previousPrevious = 1;
    int previous = 2;
    int current = 0;
    int count = 2;
    while (count != n) {
      current = previousPrevious + previous;
      previousPrevious = previous;
      previous = current;
      count++;
    }
    return current;
  }
}
