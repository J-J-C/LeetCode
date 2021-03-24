package medium;

import utils.TreeNode;

public class Num1448_CountGoodNodesInBinaryTree {

  public int goodNodes(TreeNode root) {
    return goodNode(root, Integer.MIN_VALUE);
  }

  public int goodNode(TreeNode node, int maxValue) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return node.val >= maxValue ? 1 : 0;
    }
    int count = node.val >= maxValue ? 1 : 0;
    maxValue = node.val >= maxValue ? node.val : maxValue;
    count += goodNode(node.left, maxValue);
    count += goodNode(node.right, maxValue);
    return count;
  }
}
