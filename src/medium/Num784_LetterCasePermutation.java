package medium;

import java.util.ArrayList;
import java.util.List;

public class Num784_LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> resultList = new ArrayList<>();
        helper(S, 0, "", resultList);
        return resultList;
    }

    public void helper(String s, int currentIndex, String partialResult, List<String> resultList) {
        if (currentIndex == s.length()) {
            resultList.add(partialResult);
        } else {
            if (Character.isDigit(s.charAt(currentIndex))) {
                helper(s, currentIndex + 1, partialResult + s.charAt(currentIndex), resultList);
            } else {
                helper(
                        s,
                        currentIndex + 1,
                        partialResult + Character.toLowerCase(s.charAt(currentIndex)),
                        resultList);
                helper(
                        s,
                        currentIndex + 1,
                        partialResult + Character.toUpperCase(s.charAt(currentIndex)),
                        resultList);
            }
        }
    }
}
