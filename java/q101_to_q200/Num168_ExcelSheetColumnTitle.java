package q101_to_q200;

public class Num168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        int base = 64;
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            int value = n % 26;
            if (value == 0) {
                value = 26;
            }

            char c = (char) (base + value);
            builder.append(c);
            n = n / 26;
            if (value == 26) {
                n -= 1;
            }
        }

        return builder.reverse().toString();
    }
}
