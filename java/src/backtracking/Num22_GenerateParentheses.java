package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Num22_GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> solution = new ArrayList<>();
    generateParenthesis(n, n, solution, "");
    return solution;
  }

  public void generateParenthesis(int head, int tail, List<String> solution, String tempSolution) {
    // we have a solution
    if (tail == 0) {
      solution.add(tempSolution);
    } else if (head == 0) {
      // no more ( , append ) only
      generateParenthesis(head, tail - 1, solution, tempSolution + ")");
    } else if (head == tail) {
      // we can only append ( if head > tail
      generateParenthesis(head - 1, tail, solution, tempSolution + "(");
    } else {
      generateParenthesis(head, tail - 1, solution, tempSolution + ")");
      generateParenthesis(head - 1, tail, solution, tempSolution + "(");
    }
  }
}
