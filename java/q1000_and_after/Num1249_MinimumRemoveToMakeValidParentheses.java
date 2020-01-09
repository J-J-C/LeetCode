package q1000_and_after;

import java.util.Stack;

public class Num1249_MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String test = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValidString(test));

//        test = "a)b(c)d";
//        System.out.println(minRemoveToMakeValidString(test));
//
//        test = "))((";
//        System.out.println(minRemoveToMakeValidString(test));
//
//        test = "(a(b(c)d)";
//        System.out.println(minRemoveToMakeValidString(test));
    }

    public static String minRemoveToMakeValidString(String string) {
        // assume string is all lower case
        if (string.length() == 0) {
            return string;
        }
        if(!string.contains("(") || !string.contains(")")) {
            return string;
        }
        StringBuilder frontBuilder = new StringBuilder();
        StringBuilder backBuilder = new StringBuilder();
        int head = 0;
        int tail = string.length() - 1;
        Stack s = new Stack();
        while(head < tail) {
            char headChar = string.charAt(head);
            char tailChar = string.charAt(tail);

            while(isLowLetter(headChar) || headChar == ')') {
                if(headChar == ')') {
                    // do nothing
                } else {
                    frontBuilder.append(headChar);
                }
                head++;
                headChar = string.charAt(head);
            }
            System.out.println("stopped");
            if(headChar == '(') {
                while(isLowLetter(tailChar) || tailChar == '(') {
                    if(headChar == '(') {
                        // do nothing
                    } else {
                        backBuilder.append(tailChar);
                    }
                    tail--;
                    tailChar = string.charAt(tail);
                }
                if(tailChar == ')') {
                    if(head < tail) {
                        frontBuilder.append(headChar);
                        backBuilder.append(tailChar);
                        head++;
                        tail--;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(frontBuilder.toString());
            System.out.println(backBuilder.reverse().toString());
            System.out.println(head);
            System.out.println(tail);
        }
        return frontBuilder.toString() + backBuilder.reverse().toString();
    }


    private static boolean isLowLetter(char c) {
//        System.out.println(c);
//        System.out.println(c >= 97 && c <=122);
        return c >= 97 && c <=122;
    }

}
