package easy;

import utils.TreeNode;

public class Num270_ClosestBinarySearchTreeValue {

  public int closestValue(TreeNode root, double target) {

    return closestValueHelper(root, target).val;
  }

  public TreeNode closestValueHelper(TreeNode root, double target) {
    if (root == null) {
      return root;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    TreeNode left = closestValueHelper(root.left, target);
    TreeNode right = closestValueHelper(root.right, target);

    double leftDiff = Integer.MAX_VALUE;
    double rightDiff = Integer.MAX_VALUE;
    if (left != null) {
      leftDiff = Math.abs(target - left.val);
    }
    if (right != null) {
      rightDiff = Math.abs(target - right.val);
    }

    double currentDiff = Math.abs(target - root.val);

    double smallest = Math.min(currentDiff, Math.min(leftDiff, rightDiff));
    if (smallest == leftDiff) {
      return left;
    } else if (smallest == rightDiff) {
      return right;
    } else {
      return root;
    }
  }
}
