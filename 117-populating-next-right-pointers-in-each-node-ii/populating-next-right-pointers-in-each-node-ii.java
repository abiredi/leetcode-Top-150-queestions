/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node formedLinkedList;
    Node prevToPoint;
    private void childNode(Node childNode){
        if(childNode != null){
            if(prevToPoint != null){
                prevToPoint.next = childNode;
            }else{
                formedLinkedList = childNode;
            }

            prevToPoint = childNode;
        }
    }
    public Node connect(Node root) {

        if(root == null) return root;

        formedLinkedList = root;        

        while(formedLinkedList != null){
            Node current = formedLinkedList;
            prevToPoint = null;
            formedLinkedList = null;
            
            while(current != null){
                             
                childNode(current.left);
                childNode(current.right);

                current = current.next;
                            
            }
        }

        return root;
    }
}


class Solution2 {
    public Node connect(Node root) {

        if(root == null) return root;

        Node formedLinkedList = root;        

        while(formedLinkedList != null){
            Node current = formedLinkedList;
            Node prevToPoint = null;
            formedLinkedList = null;
            
            while(current != null){
                             
                Node left = current.left;
                Node right = current.right;

                if(prevToPoint != null){
                    prevToPoint.next = current.left != null ? left : right;
                } 

                if(right != null){
                    prevToPoint = right;
                }else if(left != null){
                    prevToPoint = left;
                }

                if(left != null && right != null){
                    left.next = right;
                }

                if(formedLinkedList == null){
                    formedLinkedList = left != null ? left : right;
                }

                current = current.next;
                            
            }
        }

        return root;
    }
}

class Solution1 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        if(root == null) return root;

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                             
                Node current = queue.poll();

                if(i < size-1)
                    current.next = queue.peek();

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }              
            }
        }

        return root;
    }
}

