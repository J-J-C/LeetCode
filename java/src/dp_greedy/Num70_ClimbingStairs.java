package dp_greedy;

public class Num70_ClimbingStairs {
  public int climbStairsRecursion(int n) {

    if (n <= 2) {
      return n;
    }

    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int previou1 = 1;
    int previous2 = 2;
    int current = 0;
    while (n >= 3) {
      current = previou1 + previous2;
      previou1 = previous2;
      previous2 = current;
      n--;
    }
    return current;
  }

  public int climbStairsFibFormula(int n) {
    double sqrt5 = Math.sqrt(5);
    double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
    return (int) (fibn / sqrt5);
  }
}
