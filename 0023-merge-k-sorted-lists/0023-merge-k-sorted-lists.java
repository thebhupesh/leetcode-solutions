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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode head = null;
        ListNode curr = null;

        for(ListNode list : lists) if(list != null) q.add(list);

        while(!q.isEmpty()) {
            ListNode temp = q.poll();

            if(head == null) {
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = curr.next;
            }

            if(temp.next != null) q.add(temp.next);
        }

        return head;
    }
}