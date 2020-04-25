package string;

import java.util.Stack;

public class Num856_ScoreOfParentheses {

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    // imagine it like a tree, when node contains both leaf, remove both leaves and update root value
    public static int scoreOfParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(0);
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                stack.push(0);
            } else {
                int currentDepth = stack.pop();
                int rootDepth = stack.pop();
                if (currentDepth == 0) {
                    stack.push(rootDepth + 1);
                } else {
                    stack.push(rootDepth + 2 * currentDepth);
                }
            }
            index++;
        }
        return stack.pop();
    }

    public int scoreOfParenthesesPowerOfTwo(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += (int) Math.pow(2, bal);
            }
        }

        return ans;
    }
}
