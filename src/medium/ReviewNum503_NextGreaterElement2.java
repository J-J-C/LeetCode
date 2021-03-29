package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReviewNum503_NextGreaterElement2 {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(arr1)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int subResult = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > value) {
                    subResult = nums[j];
                    break;
                }
            }
            Queue<Integer> previous = new LinkedList<>();
            if (subResult > Integer.MIN_VALUE) {
                queue.add(value);
            } else {
                while (!queue.isEmpty()) {
                    int top = queue.poll();
                    previous.add(top);
                    if (top > value) {
                        subResult = top;
                        break;
                    }
                }
                while (!queue.isEmpty()) {
                    previous.add(queue.poll());
                }
                previous.add(value);
                queue = previous;
            }
            result[i] = subResult == Integer.MIN_VALUE ? -1 : subResult;
        }
        return result;
    }

    public int[] nextGreaterElements2UsingStack(int[] nums) {

        return null;
    }
}
