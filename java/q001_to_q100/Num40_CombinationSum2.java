package q001_to_q100;


import java.util.*;

public class Num40_CombinationSum2 {


    public static void main(String[] args) {
        int[] array = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> resultList = combinationSum2(array, target);

        resultList.forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        combinationSumHelper(resultList, new ArrayList<Integer>(), 0, target, candidates);
        // now remove duplicates


        return resultList;
    }


    public static void combinationSumHelper(List<List<Integer>> resultList, List<Integer> partialSolution, int startIndex, int remaining, int[] candidates) {
        if (remaining > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                //remove duplicates.
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    System.out.println(i);
                    continue;
                }
                partialSolution.add(candidates[i]);
                combinationSumHelper(resultList, partialSolution, i + 1, remaining - candidates[i], candidates);
                partialSolution.remove(partialSolution.size() - 1);
            }
        }
        if (remaining == 0) {
            resultList.add(new ArrayList<>(partialSolution));
        }
    }
}
