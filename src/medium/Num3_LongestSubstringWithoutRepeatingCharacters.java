package medium;

import java.util.HashMap;
import java.util.Map;

public class Num3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //
        String s = "asiefjrogjafi4igjrowkvpv";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int repeat = map.get(c);
                if (repeat < start) {
                } else if (repeat == start) {
                    start++;
                } else {
                    start = repeat + 1;
                }
            }
            end = i;
            map.put(c, i);
            max = Math.max(max, end - start);
        }

        return max + 1;
    }
}
