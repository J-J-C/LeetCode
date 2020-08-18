package tree_graph_dfs_bfs;

import utils.TreeNode;

public class Num543_DiameterOfBinaryTree {

  int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 1;
    getHeight(root);
    return ans - 1;
  }

  public int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = getHeight(node.left);
    int right = getHeight(node.right);
    ans = Math.max(ans, left + right + 1);
    return Math.max(left, right) + 1;
  }
}
