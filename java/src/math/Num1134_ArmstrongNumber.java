package src.math;

public class Num1134_ArmstrongNumber {

  public boolean isArmstrong(int n) {

    int counter = 0;
    int number = n;
    int finalNumber = n;

    while (number > 0) {
      number /= 10;
      counter++;
    }
    int sum = 0;

    while (n > 0) {
      sum += (int) Math.pow(n % 10, counter);
      n /= 10;
    }

    return finalNumber == sum;
  }
}
