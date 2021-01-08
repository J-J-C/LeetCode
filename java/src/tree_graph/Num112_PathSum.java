package tree_graph;

import utils.TreeNode;

public class Num112_PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    // base case, no node, return false
    if (root == null) {
      return false;
    }

    // if at the bottom, check if leaf node equals to remianing sum
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }

    // dfs, subtract the sum with current value and pass down to next level
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
