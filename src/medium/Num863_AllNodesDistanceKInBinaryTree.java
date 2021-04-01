package medium;

import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Num863_AllNodesDistanceKInBinaryTree {

  Set<Integer> resultList;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    resultList = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int counter = -1;
    boolean found = false;
    TreeNode targetNode = null;
    while (!queue.isEmpty()) {
      counter++;
      Queue<TreeNode> secondQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) continue;
        if (node.val == target.val) {
          found = true;
          targetNode = node;
          break;
        }
        secondQueue.add(node.left);
        secondQueue.add(node.right);
      }
      if (found) {
        break;
      }
      queue = secondQueue;
    }
    // System.out.println(targetNode.val);

    // now we know the distance
    queue = new LinkedList<>();
    queue.add(root);
    int newDistance = Math.abs(K - counter);
    counter = -1;
    while (!queue.isEmpty()) {
      counter++;
      Queue<TreeNode> secondQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
          continue;
        }
        if (counter != newDistance) {
          if (node.left != targetNode) {
            secondQueue.add(node.left);
          }
          if (node.right != targetNode) {
            secondQueue.add(node.right);
          }
        } else {
          if ((node.right != targetNode && node.left != targetNode) || K == 1) {
            resultList.add(node.val);
          }
        }
      }
      if (counter == K) {
        break;
      }
      queue = secondQueue;
    }
    visitSubNode(targetNode, K);

    return resultList.stream().collect(Collectors.toList());
  }

  private void visitSubNode(TreeNode root, int K) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int counter = -1;
    while (!queue.isEmpty()) {
      counter++;
      Queue<TreeNode> secondQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
          continue;
        }
        if (counter != K) {
          secondQueue.add(node.left);
          secondQueue.add(node.right);
        } else {
          resultList.add(node.val);
        }
      }
      if (counter == K) {
        break;
      }
      queue = secondQueue;
    }
  }
}
