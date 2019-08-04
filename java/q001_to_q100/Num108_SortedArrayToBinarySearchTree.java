package q001_to_q100;

import utils.TreeNode;

import java.util.Arrays;

public class Num108_SortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            TreeNode node = new TreeNode(nums[1]);
            node.left = new TreeNode(nums[0]);
            return node;
        }
        int mid = nums.length / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return node;
    }
}
