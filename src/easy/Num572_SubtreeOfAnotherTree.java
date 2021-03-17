package easy;

import utils.TreeNode;

public class Num572_SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    return equalTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean equalTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.val != t.val) {
      return false;
    } else {
      return (equalTree(s.left, t.left) && equalTree(s.right, t.right));
    }
  }
}
