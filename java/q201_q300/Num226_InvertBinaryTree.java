package q201_q300;

import utils.TreeNode;

public class Num226_InvertBinaryTree {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);

        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
