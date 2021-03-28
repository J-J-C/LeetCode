package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Num545_BoundaryOfBinaryTree {

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(root.val);
    helperForLeft(root.left, true, result);
    helperForRight(root.right, true, result);

    return result;
  }

  public void helperForLeft(TreeNode node, boolean isFromLeft, List<Integer> subResult) {
    // base case
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      subResult.add(node.val);
      return;
    }
    // if we are from left bound, pre order add the value
    if (isFromLeft) {
      subResult.add(node.val);
    }
    // since left child is empty, the right child may carry over
    // the left bound duty
    if (node.left == null) {
      helperForLeft(node.right, isFromLeft, subResult);
    } else {
      helperForLeft(node.left, isFromLeft, subResult);
      helperForLeft(node.right, false, subResult);
    }
  }

  public void helperForRight(TreeNode node, boolean isFromRight, List<Integer> subResult) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      subResult.add(node.val);
      return;
    }
    // since right child is empty, the left child may carry over
    // the right bound duty
    if (node.right == null) {
      helperForRight(node.left, isFromRight, subResult);
    } else {
      helperForRight(node.left, false, subResult);
      helperForRight(node.right, isFromRight, subResult);
    }
    // right is post-order, add it after the pop up
    if (isFromRight) {
      subResult.add(node.val);
    }
  }
}
