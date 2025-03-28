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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output;

        queue.add(root);
        int levelSize = 0;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for(int i=0; i<levelSize ; i++){
                TreeNode current = queue.poll();
                levelList.add(current.val);

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            output.add(levelList);
            
        }

        return output;
        
    }
}