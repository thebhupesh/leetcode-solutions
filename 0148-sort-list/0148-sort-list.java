/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        while(head != null) {
            q.offer(head);
            head = head.next;
        }

        ListNode res = q.poll();
        ListNode curr = res;

        while(!q.isEmpty()) {
            ListNode temp = q.poll();
            curr.next = temp;
            curr = temp;
        }

        curr.next = null;

        return res;
    }
}