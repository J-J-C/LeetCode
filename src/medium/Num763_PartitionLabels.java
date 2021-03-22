package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Num763_PartitionLabels {
    public List<Integer> partitionLabels(String s) {

        Stack<int[]> stack = new Stack<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        int[] first = new int[]{0, last[s.charAt(0)]};
        stack.push(first);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int end = last[c];
            int[] top = stack.peek();

            // within bound, do nothing
            if (end < top[1]) {
                continue;
            }
            // across bound, update

            else if (i < top[1] && end > top[1]) {
                top[1] = end;
            }
            // out bound, new

            else if (i > top[1]) {
                stack.push(new int[]{i, end});
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] array = stack.pop();
            result.add(array[1] - array[0] + 1);
        }

        Collections.reverse(result);
        return result;
    }

    public List<Integer> partitionLabelsOptimal(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }
}
