package easy;

public class Num415_AddStrings {

    public String addStrings(String num1, String num2) {

        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }

        StringBuilder builder = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carryOver = 0;
        while (index1 >= 0 && index2 >= 0) {
            int a = num1.charAt(index1) - '0';
            int b = num2.charAt(index2) - '0';

            int value = (a + b + carryOver) % 10;
            carryOver = (a + b + carryOver) / 10;

            builder.append(value);
            index1--;
            index2--;
        }

        while (index1 >= 0) {
            int a = num1.charAt(index1) - '0';
            int value = (a + carryOver) % 10;
            carryOver = (a + carryOver) / 10;

            builder.append(value);
            index1--;
        }

        while (index2 >= 0) {
            int a = num2.charAt(index2) - '0';
            int value = (a + carryOver) % 10;
            carryOver = (a + carryOver) / 10;

            builder.append(value);
            index2--;
        }
        if (carryOver > 0) {
            builder.append(carryOver);
        }
        return builder.reverse().toString();
    }
}
