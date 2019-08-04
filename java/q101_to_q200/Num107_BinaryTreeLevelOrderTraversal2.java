package q101_to_q200;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num107_BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        levelOrderBottom(root, listList, 0);
        Collections.reverse(listList);
        return listList;
    }


    public void levelOrderBottom(TreeNode root, List<List<Integer>> listList, int level) {
        if (root == null) {
            return;
        }
        if (listList.size() <= level) {
            List<Integer> list = new ArrayList<>();
            listList.add(list);
        }
        listList.get(level).add(root.val);
        if (root.left == null && root.right == null) {
            return;
        }

        levelOrderBottom(root.left, listList, level + 1);
        levelOrderBottom(root.right, listList, level + 1);
    }
}
