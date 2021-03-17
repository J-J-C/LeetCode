package medium;

import java.util.ArrayList;
import java.util.List;

public class Num22_GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generateParenthesis(n, n, "", result);
    return result;
  }

  public void generateParenthesis(
          int leftN, int rightN, String currentResult, List<String> finalResult) {
    if (leftN == 0 && rightN == 0) {
      finalResult.add(currentResult);
      return;
    }
    if (leftN == 0) {
      generateParenthesis(leftN, rightN - 1, currentResult + ")", finalResult);
    } else if (leftN == rightN) {
      generateParenthesis(leftN - 1, rightN, currentResult + "(", finalResult);
    } else if (leftN < rightN) {
      generateParenthesis(leftN - 1, rightN, currentResult + "(", finalResult);
      generateParenthesis(leftN, rightN - 1, currentResult + ")", finalResult);
    }
  }
}
