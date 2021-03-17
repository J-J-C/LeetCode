package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Num20_ValidParentheses {

    public boolean isValid(String s) {

        if (s.length() <= 1) {
            return s.length() == 0;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
