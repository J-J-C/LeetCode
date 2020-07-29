package src.math;

public class Num258_AddDigits {

  public int addDigits(int num) {
    if (num < 10) {
      return num;
    }
    int result = 0;

    while (num >= 10) {
      while (num > 0) {
        result += num % 10;
        num /= 10;
      }
      if (result < 10) {
        break;
      }
      num = result;
      result = 0;
    }
    return result;
  }

  public int addDigitsRecursion(int num) {
    if (num < 10) {
      return num;
    }
    return helper(num, 0);
  }

  public int helper(int num, int result) {
    if (result < 10 && num == 0) {
      return result;
    }
    if (num == 0) {
      return helper(result, 0);
    } else {
      return helper(num / 10, result + num % 10);
    }
  }

  public int addDigitsMathTrick(int num) {
    if (num == 0) {
      return 0;
    }
    if (num % 9 == 0) {
      return 9;
    } else {
      return num % 9;
    }
  }
}
