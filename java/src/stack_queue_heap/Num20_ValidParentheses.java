package stack_queue_heap;

import java.util.Stack;

public class Num20_ValidParentheses {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);

      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char pop = stack.pop();
        if ((pop == '{' && c != '}') || (pop == '[' && c != ']') || (pop == '(' && c != ')')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid2(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);

      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char pop = stack.pop();
        if ((pop == '{' && c != '}') || (pop == '[' && c != ']') || (pop == '(' && c != ')')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
