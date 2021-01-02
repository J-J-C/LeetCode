package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Num46_Permutations {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> solution = permute(nums);

    System.out.println("Final solution");
    solution.forEach(sub -> System.out.println(Arrays.toString(sub.toArray())));
  }

  public static List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> solution = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    Set<Integer> candidates = Arrays.stream(nums).boxed().collect(Collectors.toSet());

    helper(solution, current, candidates);

    return solution;
  }

  private static void helper(
          List<List<Integer>> solution, List<Integer> current, Set<Integer> candidates) {

    if (candidates.isEmpty()) {
      solution.add(current.stream().collect(Collectors.toList()));
      return;
    }

    for (int candidate : candidates) {
      current.add(candidate);
      int index = current.size() - 1;
      Set<Integer> newCandidates = candidates.stream().collect(Collectors.toSet());
      newCandidates.remove(candidate);
      helper(solution, current, newCandidates);
      current.remove(index);
    }
  }

  public void backtrack(int length, ArrayList<Integer> nums, List<List<Integer>> solution, int first) {
    if (first == length) {
      solution.add(new ArrayList<>(nums));
    }
    for (int i = first; i < length; i++) {
      Collections.swap(nums, first, i);
      backtrack(length, nums, solution, first + 1);
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permuteOptimal(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();

    // convert nums into list since the output is a list of lists
    ArrayList<Integer> subSolutionList = new ArrayList<>();
    for (int num : nums) {
      subSolutionList.add(num);
    }

    int length = nums.length;
    backtrack(length, subSolutionList, output, 0);
    return output;
  }
}
