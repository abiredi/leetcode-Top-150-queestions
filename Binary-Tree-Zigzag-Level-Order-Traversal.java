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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
       List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node;
                if(leftToRight){
                    node = queue.pollFirst();
                    if(node.left!=null) queue.addLast(node.left);
                    if(node.right!=null) queue.addLast(node.right);
                }else{
                    node = queue.pollLast();
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                }
                 levelNodes.add(node.val);
            }
             leftToRight = leftToRight == false ? true : false;
            output.add(levelNodes);
        }
        return output;
    }
}