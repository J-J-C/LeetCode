package q001_to_q100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num17_LetterCombinationsOfPhoneNumber {


    private static String[][] map = new String[][]{
            {""},
            {""}, {"a", "b", "c"}, {"d", "e", "f"},
            {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinationList = new ArrayList<>();
        // two special case
        if (digits.length() == 0) {
            return combinationList;
        }
        return letterCombinations(digits, combinationList);
    }

    public List<String> letterCombinations(String digits, List<String> combinations) {
        if (digits.length() == 0) {
            return combinations;
        }
        int number = digits.charAt(0) - 48;
        List<String> newList = new ArrayList<>();

        // we now construct the string and add it to the new list
        if (combinations.size() == 0) {
            newList.addAll(Arrays.asList(map[number]));
        } else {
            for (String s : combinations) {
                for (String c : map[number]) {
                    newList.add(s + c);
                }
            }
        }

        return letterCombinations(digits.substring(1), newList);
    }
}
