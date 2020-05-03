package string;

public class Num14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] array = {"aaa", "aa", "aaa"};
        System.out.println(longestCommonPrefix(array));
    }

    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        if (strs.length == 0) {
            return commonPrefix;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (commonPrefix.length() == 0) {
                return commonPrefix;
            }
            int index = 0;
            for (char c : strs[i].toCharArray()) {
                if (index < commonPrefix.length() && c == commonPrefix.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }
            commonPrefix = commonPrefix.substring(0, index);
        }
        return commonPrefix;
    }
}
