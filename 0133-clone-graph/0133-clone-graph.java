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
        if(node == null) return null;
        
        Node clone = new Node(node.val, new ArrayList<>());

        Map<Node,Node> m = new HashMap<>();
        m.put(node,clone);

        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()) {
            Node old = q.poll();
            Node curr = m.getOrDefault(old, new Node(old.val, new ArrayList<>()));

            for(Node n : old.neighbors) {
                if(!m.containsKey(n)) {
                    m.put(n, new Node(n.val, new ArrayList<>()));
                    q.offer(n);
                }
                curr.neighbors.add(m.get(n));
            }
        }

        return clone;
    }
}