package string;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Num681_NextClosestTime {

  public static void main(String[] args) {
    System.out.println(nextClosestTime("19:34"));
    System.out.println(nextClosestTime("23:59"));
  }

  public static String nextClosestTime(String time) {
    int[] array = new int[24 * 60];
    int h1 = Integer.parseInt(time.split(":")[0]);
    int m1 = Integer.parseInt(time.split(":")[1]);
    int startIndex = h1 * 60 + m1;

    Pattern p = Pattern.compile("[" + time.replaceAll(":", "") + "]+");

    for (int i = startIndex + 1; i < array.length; i++) {
      if (p.matcher(intToTime(i, false)).matches()) {
        return intToTime(i, true);
      }
    }

    for (int i = 0; i <= startIndex; i++) {
      if (p.matcher(intToTime(i, false)).matches()) {
        return intToTime(i, true);
      }
    }
    return "";
  }

  public static String intToTime(int a, boolean withDot) {
    int hours = a / 60;
    int minutes = a % 60;
    StringBuilder builder = new StringBuilder();
    if (hours < 10) {
      builder.append("0").append(hours);
    } else {
      builder.append(hours);
    }
    if (withDot) {
      builder.append(":");
    }
    if (minutes < 10) {
      builder.append("0").append(minutes);
    } else {
      builder.append(minutes);
    }
    return builder.toString();
  }

  public String nextClosestTimeA1(String time) {
    int cur = 60 * Integer.parseInt(time.substring(0, 2));
    cur += Integer.parseInt(time.substring(3));
    Set<Integer> allowed = new HashSet();
    for (char c : time.toCharArray()) {
      if (c != ':') {
        allowed.add(c - '0');
      }
    }

    while (true) {
      cur = (cur + 1) % (24 * 60);
      int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
      search:
      {
        for (int d : digits) {
          if (!allowed.contains(d)) {
            break search;
          }
        }
        return String.format("%02d:%02d", cur / 60, cur % 60);
      }
    }
  }
}
