package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num17_LetterCombinationsOfAPhoneNumber {

    static String[] phoneNumbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("23").toArray()));
    }


    public static List<String> letterCombinations(String digits) {
        List<String> candidates = new ArrayList<>();
        return helper(digits, candidates, 0);
    }


    public static List<String> helper(String digits, List<String> candidates, int index) {

        if (index == digits.length()) {
            return candidates;
        }
        String letters = phoneNumbers[digits.charAt(index) - '0'];
        if (index == 0) {
            for (char c : letters.toCharArray()) {
                candidates.add("" + c);
            }
            return helper(digits, candidates, index + 1);
        } else {
            List<String> list = new ArrayList<>();
            for (char c : letters.toCharArray()) {
                for (String s : candidates) {
                    list.add(s + c);
                }
            }
            return helper(digits, list, index + 1);
        }
    }


}
