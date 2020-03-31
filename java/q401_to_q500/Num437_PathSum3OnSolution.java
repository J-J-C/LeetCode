package q401_to_q500;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Num437_PathSum3OnSolution {

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        findPaths(root, sum, map, 0);

        return ans;
    }

    public void findPaths(TreeNode root, int sum, Map<Integer, Integer> map, int currentSum) {
        if (root == null) return;
        currentSum += root.val;
        ans += map.getOrDefault(currentSum - sum, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        findPaths(root.left, sum, map, currentSum);
        findPaths(root.right, sum, map, currentSum);

        map.put(currentSum, map.get(currentSum) - 1);
    }
}
