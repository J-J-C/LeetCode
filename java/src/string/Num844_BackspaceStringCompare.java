package string;

import java.util.Arrays;
import java.util.Stack;


public class Num844_BackspaceStringCompare {

  public static void main(String[] args) {
    System.out.println(backspaceCompareUsingTwoPointer(
        "xywrrmp",
        "xywrrmu#p"
    ));
  }

  public static boolean backspaceCompareUsingTwoPointer(String s, String t) {
    int i = s.length() - 1, j = t.length() - 1, back;
    while (true) {
      back = 0;
      while (i >= 0 && (back > 0 || s.charAt(i) == '#')) {
        back += s.charAt(i) == '#' ? 1 : -1;
        i--;
      }
      back = 0;
      while (j >= 0 && (back > 0 || t.charAt(j) == '#')) {
        back += t.charAt(j) == '#' ? 1 : -1;
        j--;
      }
      if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
        i--;
        j--;
      } else {
        break;
      }
    }
    return i == -1 && j == -1;
  }

  public boolean backspaceCompareUsingStack(String s, String t) {
    Stack stack1 = new Stack<>();
    Stack stack2 = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c != '#') {
        stack1.push(c);
      } else {
        if (!stack1.isEmpty()) {
          stack1.pop();
        }
      }
    }

    for (char c : t.toCharArray()) {
      if (c != '#') {
        stack2.push(c);
      } else {
        if (!stack2.isEmpty()) {
          stack2.pop();
        }
      }
    }
    return Arrays.equals(stack1.toArray(), stack2.toArray());
  }
}
