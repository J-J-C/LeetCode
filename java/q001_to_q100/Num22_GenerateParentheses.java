package q001_to_q100;

import java.util.*;
import java.util.stream.Collectors;

public class Num22_GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);


        System.out.println("----------------------final result---------------------");
        System.out.println(result.stream().collect(Collectors.joining(",")));
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> list = new HashSet<>();
        if (n == 0) {
            return new ArrayList<>(list);
        }
        if (n == 1) {
            list.add("()");
            return new ArrayList<>(list);
        }
        for (int i = 0; i < n; i++) {
            list.add("(");
        }

        Set<String> result = generateParenthesis(list, n - 1, n);
        return new ArrayList<>(result);
    }


    public static Set<String> generateParenthesis(Set<String> list, int left, int right) {
        Set<String> sublist = new HashSet<>();
        if (right == 0) {
            return list;
        } else if (left == 0) {
            for (String s : list) {
                sublist.add(s + ")");
            }
            sublist = generateParenthesis(sublist, left, right - 1);
        } else if (left == right) {
            for (String s : list) {
                sublist.add(s + "(");
            }
            sublist = generateParenthesis(sublist, left - 1, right);
        } else {

            for (String s : list) {
                sublist.add(s + "(");
            }
            sublist = generateParenthesis(sublist, left - 1, right);
            Set<String> sublist2 = new HashSet<>();
            for (String s : list) {
                sublist2.add(s + ")");
            }
            sublist2 = generateParenthesis(sublist2, left, right - 1);
            sublist.addAll(sublist2);
        }
        return sublist;
    }



    class ClosureNumber {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generateParenthesis(c))
                        for (String right: generateParenthesis(n-1-c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }
    }

    class ElegantBackTracking {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur+"(", open+1, close, max);
            if (close < open)
                backtrack(ans, cur+")", open, close+1, max);
        }
    }
}
