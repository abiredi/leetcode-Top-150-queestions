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
    int k=0;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }


        return tree(preorder, 0, preorder.length);
                
    }

    private TreeNode tree(int[] preorder, int left, int right){
        if(left >= right){
            return null;
        }       

        TreeNode currentNode = new TreeNode(preorder[k++]);

        int mid = inorderMap.get(currentNode.val);

        currentNode.left = tree(preorder, left, mid);
        currentNode.right = tree(preorder, mid+1, right);

        return currentNode;

    }
}

class Solution1 {
    TreeNode root;
    int k=0;
    int[] preorder1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder1 = preorder;
        tree(inorder, 0, inorder.length);
        

        return root;
        
    }

    private TreeNode tree(int[] inorder, int left, int right){
        if(left >= right){
            return null;
        }
        

        int i;

        for(i=left ;i<right; i++){
            if(inorder[i] == preorder1[k])break;
        }

        TreeNode currentNode = new TreeNode(preorder1[k++]);

        if(root == null) root = currentNode;

        currentNode.left = tree(inorder, left, i);
        currentNode.right = tree(inorder, i+1, right);

        return currentNode;

    }
}