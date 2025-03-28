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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> output = new ArrayList<>();

        if(root == null) return output;

        queue.add(root);
        int levelSize = 0;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            Long levelSum = 0L;

            for(int i=0; i<levelSize ; i++){
                TreeNode current = queue.poll();
                levelSum += current.val;

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            output.add((double) levelSum/levelSize);
            
        }

        return output;
    }
}