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
    public ListNode oddEvenList(ListNode head) {
        int pos = 1;
        ListNode curr = head;
        ListNode evenStart = null;
        ListNode even = null;
        ListNode odd = null;

        while(curr != null) {
            if(pos%2 == 0) {
                if(evenStart == null) {
                    evenStart = curr;
                    even = curr;
                } else {
                    even.next = curr;
                    even = curr;
                }
            } else {
                if(odd == null) odd = curr;
                else {
                    odd.next = curr;
                    odd = curr;
                }
            }

            curr = curr.next;
            pos++;
        }

        if(even != null) {
            even.next = null;
            odd.next = evenStart;
        }

        return head;
    }
}