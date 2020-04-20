package math;

import java.util.Arrays;

public class Num43_MultiplyStrings {
    public static void main(String[] args) {
//        System.out.println(multiply("123", "456"));
//        System.out.println(123 * 456);

        System.out.println(multiply("999", "999"));
        System.out.println(999 * 999);
    }

    public static String multiply(String num1, String num2) {
        int[] array = new int[num1.length() + num2.length()];
        Arrays.fill(array, 0);
        int ptr1 = num1.length() - 1;
        int ptr2 = num2.length() - 1;
        int beginIndex = array.length - 1;
        int counter = 0;
        while (ptr2 >= 0 && ptr1 >= 0) {
            while (ptr1 >= 0) {
                int value = (num1.charAt(ptr1) - '0') * (num2.charAt(ptr2) - '0');
                array[beginIndex] = array[beginIndex] + value % 10;
                array[beginIndex - 1] = array[beginIndex - 1] + value / 10;
                ptr1--;
                beginIndex--;
            }

            counter++;
            ptr1 = num1.length() - 1;
            beginIndex = array.length - 1 - counter;
            ptr2--;
        }

        StringBuilder builder = new StringBuilder();
        int carryover = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append((array[i] + carryover) % 10);
            carryover = (array[i] + carryover) / 10;
        }
        builder.reverse();
        while (builder.length() != 0 && builder.charAt(0) == '0') builder.deleteCharAt(0);
        return builder.length() == 0 ? "0" : builder.toString();
    }
}