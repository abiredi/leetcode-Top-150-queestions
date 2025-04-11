/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// class Solution{
//     private HashMap<Node, Node> visited = new HashMap<>();
//     public Node cloneGraph(Node node) {
//         if(node == null){
//             return node;
//         }

//         if(visited.containsKey(node)) return visited.get(node);

//         Node clonedNode = new Node(node.val, new ArrayList<>());
//         visited.put(node, clonedNode);

//         for(Node neighbour : node.neighbors){
//             clonedNode.neighbors.add(cloneGraph(neighbour));
//         }

//         return clonedNode;
//     }
// }
class Solution {
    
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> visited = new HashMap<>();
        if(node == null){
            return node;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));


        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            for(Node neighbor : currentNode.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }

                visited.get(currentNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}