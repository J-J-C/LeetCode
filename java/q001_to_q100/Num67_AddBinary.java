package q001_to_q100;

public class Num67_AddBinary {

    public String addBinary(String a, String b) {

        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        StringBuilder builder = new StringBuilder();
        int index1 = num1.length - 1;
        int index2 = num2.length - 1;
        int increment = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index2 == -1) {
                if (increment == 1 && num1[index1] == '0') {
                    builder.append(1);
                    increment = 0;
                } else if (increment == 1 && num1[index1] == '1') {
                    builder.append(0);
                    increment = 1;
                } else {
                    builder.append(num1[index1]);
                }
                index1--;

            } else if (index1 == -1) {
                if (increment == 1 && num2[index2] == '0') {
                    builder.append(1);
                    increment = 0;
                } else if (increment == 1 && num2[index2] == '1') {
                    builder.append(0);
                    increment = 1;
                } else {
                    builder.append(num2[index2]);
                }
                index2--;

            } else {
                int d1 = num1[index1] - '0';
                int d2 = num2[index2] - '0';
                int value = d1 + d2 + increment;
                builder.append(value % 2);
                increment = value / 2;
                index1--;
                index2--;
            }
        }
        if (increment == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
