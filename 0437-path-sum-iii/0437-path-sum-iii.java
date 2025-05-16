/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L,1);

        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumCount){

        if(node == null) return 0;
        currSum += node.val;

        int numPaths = prefixSumCount.getOrDefault(currSum-targetSum, 0);

        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        numPaths += dfs(node.left, currSum, targetSum, prefixSumCount);
        numPaths += dfs(node.right, currSum, targetSum, prefixSumCount);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum)-1);

        return numPaths;

    }
}