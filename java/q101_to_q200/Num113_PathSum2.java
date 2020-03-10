package q101_to_q200;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Num113_PathSum2 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();


        if (root == null) {
            return result;
        }

        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(root.val);
        List<Integer> tempResult2 = new ArrayList<>();
        tempResult2.add(root.val);

        hasPathSum(root.left, sum - root.val, tempResult, result);
        hasPathSum(root.right, sum - root.val, tempResult2, result);
        return result;
    }

    public void hasPathSum(TreeNode root, int sum, List<Integer> tempResult, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                tempResult.add(root.val);
                result.add(tempResult);
            }
            return;
        }
        tempResult.add(root.val);
        List<Integer> tempResultRight = new ArrayList<>(tempResult);
        hasPathSum(root.left, sum - root.val, tempResult, result);
        hasPathSum(root.right, sum - root.val, tempResultRight, result);
    }
}
