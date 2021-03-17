package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Num17_LetterCombinationsOfAPhoneNumber {

  private static final Map<Character, String> map =
          Map.of(
                  '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9',
                  "wxyz");

  public List<String> letterCombinations(String digits) {

    List<String> finalResult = new ArrayList<>();
    if (digits.length() == 0) {
      return finalResult;
    }
    letterCombinations(digits, 0, "", finalResult);
    return finalResult;
  }

  public void letterCombinations(
          String digits, int index, String tempResult, List<String> finalResult) {
    if (index == digits.length()) {
      finalResult.add(tempResult);
      return;
    }

    String letters = map.get(digits.charAt(index));
    for (char c : letters.toCharArray()) {
      letterCombinations(digits, index + 1, tempResult + c, finalResult);
    }
  }
}
