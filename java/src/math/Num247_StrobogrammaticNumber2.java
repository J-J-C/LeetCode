package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num247_StrobogrammaticNumber2 {

  // string pair: 11, 00, 69, 96, 88
  public List<String> findStrobogrammatic(int n) {
    List<String> resultList = new ArrayList<>();
    findStrobogrammatic(n, "", resultList);
    Collections.sort(resultList);
    return resultList;
  }

  private void findStrobogrammatic(int n, String s, List<String> resultList) {
    if (n == 0) {
      if (s.charAt(0) == '0') {
        return;
      }
      resultList.add(s);
      return;
    }
    if (n == 1) {
      resultList.add(s.substring(0, s.length() / 2) + "1" + s.substring(s.length() / 2));
      resultList.add(s.substring(0, s.length() / 2) + "8" + s.substring(s.length() / 2));
      resultList.add(s.substring(0, s.length() / 2) + "0" + s.substring(s.length() / 2));
      return;
    }

    int a = n - 2;
    findStrobogrammatic(a, "0" + s + "0", resultList);
    findStrobogrammatic(a, "1" + s + "1", resultList);
    findStrobogrammatic(a, "8" + s + "8", resultList);
    findStrobogrammatic(a, "6" + s + "9", resultList);
    findStrobogrammatic(a, "9" + s + "6", resultList);
  }

  public List<String> findStrobogrammatic2(int n) {
    return helper(n, n);
  }

  List<String> helper(int n, int m) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }
    if (n == 1) {
      return new ArrayList<>(Arrays.asList("0", "1", "8"));
    }

    List<String> list = helper(n - 2, m);
    List<String> res = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      if (n != m) {
        res.add("0" + s + "0");
      }
      res.add("1" + s + "1");
      res.add("6" + s + "9");
      res.add("8" + s + "8");
      res.add("9" + s + "6");
    }
    return res;
  }
}
