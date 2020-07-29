package src.math;

public class Num1323_Maximum69Number {

  public int maximum69Number(int num) {

    int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();
    boolean changed = false;
    int sum = 0;
    for (int i = 0; i < digits.length; i++) {
      sum *= 10;
      if (digits[i] != 9 && !changed) {
        digits[i] = 9;
        changed = true;
      }
      sum += digits[i];
    }
    return sum;
  }

  public int maximum69NumberOptimal(int num) {
    int firstSix = -1;
    int number = num;
    for (int i = 0; number > 0; i++) {
      if (number % 10 == 6) {
        firstSix = i;
      }
      number /= 10;
    }
    return num + 3 * (int) Math.pow(10, firstSix);
  }
}
