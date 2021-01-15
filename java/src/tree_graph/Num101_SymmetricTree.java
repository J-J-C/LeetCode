package tree_graph;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Num101_SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }

    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    } else {
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
  }

  public boolean isSymmetricIterative(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }
}
