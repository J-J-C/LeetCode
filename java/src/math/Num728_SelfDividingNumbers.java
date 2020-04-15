package src.math;

import java.util.ArrayList;
import java.util.List;

public class Num728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>((right - left) / 2);
        for (int i = left; i <= right; i++) {
            if (i < 10) {
                list.add(i);
                continue;
            }
            if (i % 10 == 0) {
                continue;
            }
            if (isSelfiDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfiDividing(int number) {
        int mirror = number;
        while (mirror != 0) {
            int digit = (mirror % 10);
            if (digit == 0) {
                return false;
            }
            if (number % digit != 0) {
                return false;
            }
            mirror /= 10;
        }
        return true;
    }
}
