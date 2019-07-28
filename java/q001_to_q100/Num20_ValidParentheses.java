package q001_to_q100;

import java.util.Stack;

public class Num20_ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]"));
    System.out.println(isValid("((()))"));
    System.out.println(isValid("(([]{([()])}))(())"));

  }

  public static boolean isValid(String s) {
    if (s.length() == 0) {
      return true;
    }

    if (s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if(stack.isEmpty()) {
          return false;
        }
        if (c == ')') {
          if (stack.pop() != '(') {
            return false;
          }
        }
        if (c == '}') {
          if (stack.pop() != '{') {
            return false;
          }
        }
        if (c == ']') {
          if (stack.pop() != '[') {
            return false;
          }
        }

      }
    }
    return stack.isEmpty();
  }
}
