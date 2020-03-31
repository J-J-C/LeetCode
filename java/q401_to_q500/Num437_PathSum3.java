package q401_to_q500;

import utils.TreeNode;

public class Num437_PathSum3 {


    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }



        if (root.val == sum) {
            return 1 + pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
        } else {
            return 0 + pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
        }


    }

    private int pathSumFrom(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        return pathSumFrom(root.right, sum - root.val) + pathSumFrom(root.left, sum - root.val);
    }
}
