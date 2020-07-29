package src.math;

public class Num172_FactorialTrailingZeroes {

  public static void main(String[] args) {
//        System.out.println(trailingZeroes(10));
    System.out.println(trailingZeroes(12));
  }

  public static int trailingZeroes(int n) {
    int zeroCount = 0;
    long currentMultiple = 5;
    while (n > 0) {
      n /= 5;
      zeroCount += n;
    }
    return zeroCount;
  }
}
