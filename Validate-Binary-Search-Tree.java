/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left, right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;}}
 */
class Solution {
    TreeNode last = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private boolean inorder(TreeNode node){
        if(node == null){
            return true;
        }
        boolean left = inorder(node.left);
        if(last!=null){
            if(last.val >= node.val) return false;
        }
        last=node;
        boolean right = inorder(node.right);
        return left && right;
    }
}