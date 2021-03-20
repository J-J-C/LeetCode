package easy;

public class Num1427_PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        // positive: left shift   >>>
        // negative: right shift  <<<

        if (shift.length == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();

        int positionShifted = 0;

        for (int[] i : shift) {
            if (i[0] == 0) {
                positionShifted += i[1];
            } else {
                positionShifted -= i[1];
            }
        }
        positionShifted %= s.length();

        int index = positionShifted;
        if (positionShifted < 0) {
            index = s.length() + positionShifted;
        }
        while (builder.length() < s.length()) {
            builder.append(s.charAt(index));
            index++;
            if (index == s.length()) {
                index = 0;
            }
        }
        return builder.toString();
    }
}
