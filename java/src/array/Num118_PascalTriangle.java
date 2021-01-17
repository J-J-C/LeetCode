package array;

import java.util.ArrayList;
import java.util.List;

public class Num118_PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> solution = new ArrayList<>();
    if (numRows == 0) {
      return solution;
    }

    List<Integer> base = List.of(1);
    solution.add(base);
    generate(base, numRows - 1, solution);
    return solution;
  }

  private void generate(List<Integer> previousRow, int count, List<List<Integer>> solution) {
    if (count == 0) {
      return;
    }
    List<Integer> currentRow = new ArrayList<>();
    currentRow.add(1);
    for (int i = 0; i < previousRow.size() - 1; i++) {
      currentRow.add(previousRow.get(i) + previousRow.get(i + 1));
    }
    currentRow.add(1);
    solution.add(currentRow);
    generate(currentRow, count - 1, solution);
  }
}
