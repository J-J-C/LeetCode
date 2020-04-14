package src.math;

import java.util.HashSet;
import java.util.Set;

public class Num202_HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> memory = new HashSet<>();

        int result = 0;
        while (true) {
            while (n > 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
            if (result == 1) {
                return true;
            }
            if (memory.contains(result)) {
                break;
            } else {
                memory.add(result);
            }
            n = result;
            result = 0;
        }
        return false;
    }
}
