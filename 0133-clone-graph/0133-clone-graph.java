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
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Node> nodes = new HashMap<>();

        q.offer(node);
        visited.add(node.val);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            nodes.put(curr.val,new Node(curr.val));

            for(Node n : curr.neighbors) {
                if(!visited.contains(n.val)) {
                    q.offer(n);
                    visited.add(n.val);
                }
            }
        }

        q.offer(node);
        visited.clear();
        visited.add(node.val);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            Node newNode = nodes.get(curr.val);

            for(Node n : curr.neighbors) {
                newNode.neighbors.add(nodes.get(n.val));
                if(!visited.contains(n.val)) {
                    q.offer(n);
                    visited.add(n.val);
                }
            }
        }

        return nodes.get(node.val);
    }
}