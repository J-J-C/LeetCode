package tree_graph_dfs_bfs;


import java.util.LinkedList;
import java.util.Queue;
import utils.TreeNode;

public class Num226_InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }

    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);

    return root;
  }


  public TreeNode invertTree2(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return root;
  }
}
