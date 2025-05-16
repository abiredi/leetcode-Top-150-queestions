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

    private int maxLen =0; 
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0; //edge case:empty tree

        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return maxLen;
    }
    private void dfs(TreeNode node, int length, boolean isLeft){
        if(node==null) return;//base case

        maxLen = Math.max(maxLen, length);

        if(isLeft){
            dfs(node.right, length+1, false);

            dfs(node.left, 1, true);
        }else{
            dfs(node.left, length+1, true);
            dfs(node.right, 1, false);
        }
    }
}