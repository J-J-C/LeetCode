package q001_to_q100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num39_CombinationSum {


    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> resultList = combinationSum(array, target);

        resultList.forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });


    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        combinationSumHelper(resultList, new ArrayList<Integer>(), 0, target, candidates);
        return resultList;
    }


    public static void combinationSumHelper(List<List<Integer>> resultList, List<Integer> partialSolution, int startIndex, int remaining, int[] candidates) {
        if (remaining > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                partialSolution.add(candidates[i]);
                combinationSumHelper(resultList, partialSolution, i,  remaining - candidates[i], candidates);
                partialSolution.remove(partialSolution.size() - 1);
            }
        }
        if (remaining == 0) {
            resultList.add(new ArrayList<>(partialSolution));
        }
    }
}
