package src.math;

public class Num171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        int base = 1;
        int characterBase = 'A' - 1;

        int index = s.length() - 1;
        while (index >= 0) {
            char c = s.charAt(index);
            result += (c - characterBase) * base;
            base *= 26;
            index--;
        }
        return result;
    }
}
