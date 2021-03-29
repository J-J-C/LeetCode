package hard;

import utils.TreeNode;

public class Num124_BinaryTreeMaximumPathSum {

  public static int MAX_VALUE;

  public int maxPathSum(TreeNode root) {
    MAX_VALUE = Integer.MIN_VALUE;
    maxPathSumHelper(root);
    return MAX_VALUE == Integer.MIN_VALUE ? -1 : MAX_VALUE;
  }

  public int maxPathSumHelper(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      // base case
      MAX_VALUE = Math.max(node.val, MAX_VALUE);
      return node.val;
    }

    int leftSum = maxPathSumHelper(node.left);
    int rightSum = maxPathSumHelper(node.right);
    /*
      we update our max value, current max has 4 scenario
      left + right + (node || 0)
      left + (node || 0)
      right + (node || 0)
      (node || 0)
    */
    MAX_VALUE = Math.max(leftSum + rightSum + node.val, MAX_VALUE);
    MAX_VALUE = Math.max(leftSum + node.val, MAX_VALUE);
    MAX_VALUE = Math.max(rightSum + node.val, MAX_VALUE);
    MAX_VALUE = Math.max(node.val, MAX_VALUE);
    // return the maximum local path
    return Math.max(Math.max(leftSum + node.val, rightSum + node.val), node.val);
  }
}
