package q001_to_q100;

import utils.TreeNode;

public class Num100_SameTree {

    public static void main(String[] args) {
        System.out.println("lol");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (isSameTree(p.left, q.left)) {
            return isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
