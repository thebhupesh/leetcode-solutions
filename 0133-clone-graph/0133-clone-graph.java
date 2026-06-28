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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Node,Node> nodes = new HashMap<>();

        q.offer(node);
        nodes.put(node,new Node(node.val));

        while(!q.isEmpty()) {
            Node curr = q.poll();

            for(Node n : curr.neighbors) {
                if(nodes.get(n) == null) {
                    q.offer(n);
                    nodes.put(n,new Node(n.val));
                }

                nodes.get(curr).neighbors.add(nodes.get(n));
            }
        }

        return nodes.get(node);
    }
}