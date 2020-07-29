package math;

public class Num213_PowerOfTwo {


  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    if (n <= 2) {
      return true;
    }
    while (n > 1) {
      if (n % 2 != 0) {
        return false;
      }
      n = n / 2;
    }
    return true;
  }


  public boolean isPowerOfTwoBit(int n) {
    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (-x)) == x;
  }
}
