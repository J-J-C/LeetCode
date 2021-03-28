package easy;

public class Num1134_ArmstrongNumber {

  public boolean isArmstrong(int n) {

    int number = n;
    int counter = 0;
    while (number > 0) {
      counter++;
      number /= 10;
    }

    int total = 0;
    number = n;
    while (number > 0) {
      int digit = number % 10;
      int subTotal = digit;
      for (int i = 1; i < counter; i++) {
        subTotal = subTotal * digit;
      }
      total += subTotal;
      number /= 10;
    }

    return total == n;
  }
}
