package medium;

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num103_BinaryTreeZigZagLevelOrderTraversal {
  Map<Integer, LinkedList<Integer>> map;

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    map = new HashMap<>();
    zigZagVisit(root, true, 0);
    List<List<Integer>> result = new LinkedList<>();

    for (int i = 0; i < map.size(); i++) {
      result.add(map.get(i));
    }
    return result;
  }

  public void zigZagVisit(TreeNode root, boolean isFromLeft, int level) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(level)) {
      map.put(level, new LinkedList<>());
    }
    if (root.left == null && root.right == null) {
      if (isFromLeft) {
        map.get(level).addLast(root.val);
      } else {
        map.get(level).addFirst(root.val);
      }
      return;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    if (isFromLeft) {
      map.get(level).add(root.val);
      zigZagVisit(left, false, level + 1);
      zigZagVisit(right, false, level + 1);
    } else {
      map.get(level).addFirst(root.val);
      zigZagVisit(left, true, level + 1);
      zigZagVisit(right, true, level + 1);
    }
  }
}
