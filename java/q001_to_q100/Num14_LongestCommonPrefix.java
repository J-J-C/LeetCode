package q001_to_q100;

public class Num14_LongestCommonPrefix {

    public static void main(String[] args) {

        String[] array = {"flower", "flow", "flight"};
        String[] array2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(array));
        System.out.println(longestCommonPrefix(array2));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];

        for (String words : strs) {
            int length = 0;
            int stop = prefix.length() <= words.length() ? prefix.length() : words.length();
            for (int i = 0; i < stop; i++) {
                if (words.charAt(i) == prefix.charAt(i)) {
                    length++;
                } else {
                    break;
                }
            }
            prefix = prefix.substring(0, length);
        }

        return prefix;
    }
}
