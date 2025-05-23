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
    List<Integer> inorderNodes = new ArrayList<>();

    void inorderTraversal(TreeNode node){
        if(node == null) return;

        inorderTraversal(node.left);
        inorderNodes.add(node.val);
        inorderTraversal(node.right);
    }
    public int getMinimumDifference(TreeNode root){
        inorderTraversal(root);
        int minDifference = Integer.MAX_VALUE;
         // Find the diff between every two consecutive values in the list.
        for(int i =1; i<inorderNodes.size();i++){
            minDifference = Math.min(minDifference, inorderNodes.get(i) - inorderNodes.get(i-1));
        }
        return minDifference;
    }
}