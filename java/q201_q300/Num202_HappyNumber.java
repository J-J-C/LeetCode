package q201_q300;

import java.util.HashMap;
import java.util.Map;

public class Num202_HappyNumber {


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n != 1) {
            int old = n;
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (map.containsKey(old)) return false;
            map.put(old, sum);
            n = sum;
        }
        return true;
    }
}
