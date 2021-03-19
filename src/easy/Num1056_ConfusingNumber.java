package easy;

import java.util.HashSet;
import java.util.Set;

public class Num1056_ConfusingNumber {

    public static void main(String[] args) {
        //
        System.out.println(confusingNumber(916));
    }

    public static boolean confusingNumber(int N) {
        int original = N;

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(7);
        int newNumber = 0;
        while (N > 0) {
            int digit = N % 10;
            if (set.contains(digit)) {
                return false;
            }
            if (digit == 6) {
                digit = 9;
            } else if (digit == 9) {
                digit = 6;
            }
            newNumber = newNumber * 10 + digit;
            N = N / 10;
        }

        return newNumber != original;
    }
}
