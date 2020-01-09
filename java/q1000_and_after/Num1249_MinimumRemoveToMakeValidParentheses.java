package q1000_and_after;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Num1249_MinimumRemoveToMakeValidParentheses {


    @Test
    public void testMethod() {

        Assert.assertTrue("lee(t(co)de)".equals(minRemoveToMakeValid("lee(t(c)o)de)")) || "lee(t(c)o)de".equals(minRemoveToMakeValid("lee(t(c)o)de)")));
        Assert.assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
        Assert.assertEquals("", minRemoveToMakeValid("))(("));
        Assert.assertEquals("(a(bc)d)", minRemoveToMakeValid("(a(b(c)d)"));
        Assert.assertEquals("", minRemoveToMakeValid("))))"));

        Assert.assertEquals("", minRemoveToMakeValid(")))))"));
        Assert.assertEquals("()()", minRemoveToMakeValid("())()((("));
        Assert.assertEquals("i()()(fm)", minRemoveToMakeValid(")i()()((fm(((()"));
        Assert.assertEquals("(t(e)y)d()e", minRemoveToMakeValid("(t(e)y))d(()(e("));
    }


    public static String minRemoveToMakeValid(String string) {
        // assume string is all lower case
        if (string.length() == 0) {
            return string;
        }
        if (!string.contains("(") && !string.contains(")")) {
            return string;
        }

        // using a stack to memorize parentheses
        Stack stack = new Stack<>();

        char[] array = string.toCharArray();
        StringBuilder builder = new StringBuilder();

        // scanning forward....
        for (int i = 0; i < array.length; i++) {
            char c = string.charAt(i);
            if (string.charAt(i) == '(') {
                stack.push('(');
                builder.append(c);
            }
            else if (c == ')') {
                if (!stack.empty()) {
                    stack.pop();
                    builder.append(c);
                }
            } else {
                builder.append(c);
            }
        }
        // scanning backward
        while(!stack.isEmpty()) {
            builder.deleteCharAt(builder.lastIndexOf("("));
            stack.pop();
        }
        return builder.toString();
    }


    public static String minRemoveToMakeValidOriginal(String string) {
        // assume string is all lower case
        if (string.length() == 0) {
            return string;
        }
        if (!string.contains("(") && !string.contains(")")) {
            return string;
        }

        // using a stack to memorize parentheses
        Stack stack = new Stack<>();

        char[] array = string.toCharArray();


        // scanning forward....
        for(int i = 0; i < array.length; i++) {
            if(isLowLetter(array[i])) {
                continue;
            }
            if(array[i] == '(') {
                stack.push('(');
                continue;
            }
            if(array[i] == ')') {
                if(!stack.empty()) {
                    stack.pop();
                    continue;
                } else{
                    array[i] = '1';
                }
            }
        }
        // scanning backward
        for(int i = array.length - 1; i >=0; i--) {
            if(array[i] == '(') {
                if(!stack.isEmpty()) {
                    array[i] = '1';
                    stack.pop();
                }
            }
        }
        return new String(array).replaceAll("1", "");

    }


    private static boolean isLowLetter(char c) {
        return c >= 97 && c <= 122;
    }

}
