package string;

public class Num415_AddStrings {


  public static void main(String[] args) {
    System.out.println(addStrings("968", "99"));
  }

  public static String addStrings(String num1, String num2) {
    char zero = '0';
    StringBuilder builder = new StringBuilder();
    String s1, s2;
    if (num1.length() < num2.length()) {
      s1 = num1;
      s2 = num2;
    } else {
      s1 = num2;
      s2 = num1;
    }

    // s1 is always the shorter one
    int index1 = s1.length() - 1;
    int index2 = s2.length() - 1;
    int extra = 0;
    while (index1 >= 0) {

      int value = ((s2.charAt(index2) - zero) + (s1.charAt(index1) - zero) + extra);
      extra = value / 10;
      builder.append(value % 10);
      index1--;
      index2--;
    }
    while (index2 >= 0) {
      builder.append((s2.charAt(index2) - zero + extra) % 10);
      extra = (s2.charAt(index2) - zero + extra) / 10;
      index2--;
    }
    if (extra > 0) {
      builder.append(extra);
    }

    return builder.reverse().toString();
  }
}
