package q601_to_q700;

import utils.TreeNode;

public class Num687_LongestUnivaluePath {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0, arrowRight = 0;

        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
