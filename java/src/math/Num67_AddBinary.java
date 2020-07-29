package math;

public class Num67_AddBinary {

  public static void main(String[] args) {
    System.out.println(addBinary("1", "111"));
  }

  public static String addBinary(String a, String b) {
    StringBuilder builder = new StringBuilder();
    boolean carryOver = false;
    if (a.length() < b.length()) {
      String temp = a;
      a = b;
      b = temp;
    }
    int ap = a.length() - 1;
    int bp = b.length() - 1;
    while (ap >= 0 && bp >= 0) {
      if (a.charAt(ap) == b.charAt(bp)) {
        if (carryOver) {
          builder.append('1');
        } else {
          builder.append('0');
        }
        carryOver = a.charAt(ap) == '1';
      } else {
        if (carryOver) {
          builder.append('0');
        } else {
          builder.append('1');
        }
      }
      ap--;
      bp--;
    }
    while (ap >= 0) {
      if (carryOver) {
        if (a.charAt(ap) == '0') {
          carryOver = false;
          builder.append('1');
        } else {
          builder.append('0');
        }
      } else {
        builder.append(a.charAt(ap));
      }
      ap--;
    }
    if (carryOver) {
      builder.append('1');
    }
    return builder.reverse().toString();
  }
}
