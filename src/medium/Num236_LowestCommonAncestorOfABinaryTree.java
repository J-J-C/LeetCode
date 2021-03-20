package medium;

import utils.TreeNode;

public class Num236_LowestCommonAncestorOfABinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return root;
    }

    if (root.left == p && root.right == q) {
      return root;
    }
    if (root.val == p.val || root.val == q.val) {
      return root;
    }

    TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
    TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

    if (leftAncestor != null && rightAncestor != null) {
      return root;
    }
    if (leftAncestor != null) {
      return leftAncestor;
    } else {
      return rightAncestor;
    }
  }
}
