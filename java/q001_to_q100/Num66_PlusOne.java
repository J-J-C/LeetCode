package q001_to_q100;

import java.util.Arrays;

public class Num66_PlusOne {

    public static void main(String[] args) {

        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(Arrays.toString(plusOne(array)));
        int[] array2 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(array2)));

    }

    public static int[] plusOne(int[] digits) {
        String sum = "";
        int increment = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int total = increment + digits[i];
            sum = (total % 10) + sum;
            increment = total / 10;
        }
        if (increment == 1) {
            sum = 1 + sum;
        }
        System.out.println(sum);
        int[] array = new int[sum.length()];
        for (int i = 0; i < sum.length(); i++) {
            array[i] = sum.charAt(i) - 48;
        }
        return array;
    }

    public static int[] plusOneOptimal(int[] digits) {
        // Add numbers and check for carry
        // If carry over at the end, create new array and add another digit
        int[] ret;
        int carryOver = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carryOver;

            if (digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
        }

        if (carryOver == 1) {
            ret = new int[digits.length + 1];
            ret[0] = carryOver;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }

            return ret;
        }

        return digits;
    }
}
