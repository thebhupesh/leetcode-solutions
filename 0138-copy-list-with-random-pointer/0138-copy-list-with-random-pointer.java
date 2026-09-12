/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node,Node> map = new HashMap<>();
        
        Node copy = new Node(head.val);
        map.put(head, copy);
        
        while(head != null) {
            Node curr = map.getOrDefault(head, new Node(head.val));

            if(head.next != null) {
                curr.next = map.getOrDefault(head.next, new Node(head.next.val));
                map.put(head.next, curr.next);
            }
            if(head.random != null) {
                curr.random = map.getOrDefault(head.random, new Node(head.random.val));
                map.put(head.random, curr.random);
            }

            head = head.next;
        }

        return copy;
    }
}