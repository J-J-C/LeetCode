package q101_to_q200;

public class Num171_ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sum += (c - 64) * Math.pow(26, index);
            index++;
        }
        return sum;
    }
}
