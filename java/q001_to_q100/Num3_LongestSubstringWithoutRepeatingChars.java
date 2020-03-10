package q001_to_q100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num3_LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a)); // expected: 3

        String b = "bbbbbbb";
        System.out.println(lengthOfLongestSubstring(b)); // expected: 1

        String c = "pwwkew";
        System.out.println(lengthOfLongestSubstring(c)); // expected: 3

        String d = "aab";
        System.out.println(lengthOfLongestSubstring(d)); // expected: 2

        String e = "abba";
        System.out.println(lengthOfLongestSubstring(e)); // expected: 2

        String f = "wobgrovw";
        System.out.println(lengthOfLongestSubstring(f)); // expected: 6


    }

    public static int lengthOfLongestSubstring(String s) {
        // corner cases
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        // define the map and other base variables
        Map<Character, Integer> stringIntMap = new HashMap<>();

        int maxLength = 1;
        int startIndex = 0;
        int endIndex = 0;

        int pointer = 0;
        while(pointer != s.length()) {
            // if we do not find the char, put it in the map
            if(!stringIntMap.containsKey(s.charAt(pointer))) {
                stringIntMap.put(s.charAt(pointer), pointer);
                endIndex = pointer;
            }
            // we find the duplicated, before we proceed further, we check if current is bigger than the max
            else {
                if(endIndex - startIndex + 1 > maxLength) {
                    maxLength = endIndex - startIndex + 1;
                }

                if(stringIntMap.get(s.charAt(pointer)) + 1 > startIndex) {
                    startIndex = stringIntMap.get(s.charAt(pointer)) + 1;
                }

                // this block can actually be removed...
                // if endindex == pointer, then we reinitialize the map and starting point
                if(s.charAt(endIndex) == s.charAt(pointer)) {
                    startIndex = pointer;
                    stringIntMap.clear();
                }

                endIndex = pointer;
                stringIntMap.put(s.charAt(pointer), pointer);
            }
            pointer++;
        }

        if(endIndex - startIndex + 1 > maxLength) {
            maxLength = endIndex - startIndex + 1;
        }
        return maxLength;
    }

    public static int bestLengthOfLongestSubstring(String s) {
        int res = 0;
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        int i = 0, startIndex = 0;
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            // the last occurrence needs to be grater than
            // current starting index j
            if(lastIndex[c] >= startIndex){
                res = Math.max(res, i - startIndex);
                startIndex = lastIndex[c] + 1;
            }
            lastIndex[c] = i;
        }
        return Math.max(res, i - startIndex);
    }
}
