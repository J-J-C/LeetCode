package tree_graph_dfs_bfs;

import utils.TreeNode;

public class Num572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        return isSubtree2(s, t);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return equal(s, t) || isSubtree2(s.left, t) || isSubtree2(s.right, t);
    }

    public boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
}
