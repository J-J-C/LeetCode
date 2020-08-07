package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num39_CombinationSum {

  public static void main(String[] args) {
    int[] array = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> solution = combinationSum(array, target);
    for (List l : solution) {
      System.out.println(Arrays.toString(l.toArray()));
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> solution = new ArrayList<>();
    if (candidates.length == 0) {
      return solution;
    }
    List<Integer> tempSolution = new ArrayList<>();
    combinationSum(candidates, target, 0, 0, tempSolution, solution);
    return solution;
  }


  public static void combinationSum(int[] candidates, int target, int beginIndex, int currentSum,
      List<Integer> tempSolution,
      List<List<Integer>> solution) {
    if (currentSum > target) {
      return;
    }
    if (currentSum == target) {
      solution.add(new ArrayList<>(tempSolution));
      return;
    } else {
      for (int i = beginIndex; i < candidates.length; i++) {
        tempSolution.add(candidates[i]);
        combinationSum(candidates, target, i, currentSum + candidates[i], tempSolution, solution);
        tempSolution.remove(tempSolution.size() - 1);
      }
    }
  }
}
