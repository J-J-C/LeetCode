package q001_to_q100;

public class Num_13_RomanToInteger {
  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("IV"));
    System.out.println(romanToInt("IX"));
    System.out.println(romanToInt("LVIII"));
    System.out.println(romanToInt("MCMXCIV"));
  }

  public static int romanToInt(String s) {
    int value = 0;

    int currentPointer = 0;
    while (currentPointer < s.length()) {
      char current = s.charAt(currentPointer);
      value = value + value(current);
      if (currentPointer > 0) {
        char previous = s.charAt(currentPointer - 1);

        if (value(previous) < value(current)) {
          value = value - value(previous) * 2;
        }
      }
      currentPointer++;
    }
    return value;
  }

  public static int value(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return -1;
    }
  }
}
