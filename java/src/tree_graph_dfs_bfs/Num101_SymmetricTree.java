package tree_graph_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import utils.TreeNode;

public class Num101_SymmetricTree {


  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }

    if (root.left == null || root.right == null) {
      return false;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }


  public boolean isSymmetricIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }

    if (root.left == null || root.right == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);
    while (!queue.isEmpty()) {
      TreeNode left = queue.poll();
      TreeNode right = queue.poll();
      if (left == null && right == null) {
        continue;
      } else if (left == null || right == null) {
        return false;
      } else {
        if (left.val != right.val) {
          return false;
        } else {
          queue.offer(left.right);
          queue.offer(right.left);
          queue.offer(left.left);
          queue.offer(right.right);
        }
      }
    }
    return true;
  }
}
