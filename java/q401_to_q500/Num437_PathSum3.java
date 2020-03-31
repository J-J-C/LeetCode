package q401_to_q500;

import utils.TreeNode;

public class Num437_PathSum3 {


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFrom(root, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.right, sum - root.val) + pathSumFrom(root.left, sum - root.val);

    }
}
