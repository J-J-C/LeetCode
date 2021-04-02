package medium;

public class Num161_OneEditDistance {

  public static void main(String[] args) {
    //

    System.out.println(isOneEditDistance("a", ""));
  }

  public static boolean isOneEditDistance(String s, String t) {
    if (s.length() > t.length()) {
      return isOneEditDistance(t, s);
    }
    if (t.length() == 0 && s.length() == 0) {
      return false;
    }
    if (t.length() - s.length() >= 2) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(i)) {
        continue;
      } else {
        return s.substring(i + 1).equals(t.substring(i + 1))
                || s.substring(i).equals(t.substring(i + 1));
      }
    }
    return (s.length() + 1 == t.length());
  }
}
