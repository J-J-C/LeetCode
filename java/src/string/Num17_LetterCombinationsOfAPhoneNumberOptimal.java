package src.string;

import java.util.ArrayList;
import java.util.List;

public class Num17_LetterCombinationsOfAPhoneNumberOptimal {

    String[] phoneNumbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> candidates = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        helper(digits, 0, "");
        return candidates;
    }


    public void helper(String digits, int index, String current) {
        if (index == digits.length()) {
            candidates.add(current);
            return;
        }

        String letters = phoneNumbers[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            helper(digits, index + 1, current + c);
        }
    }
}
