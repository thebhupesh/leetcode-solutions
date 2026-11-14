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
        if(head == null || head.next == null) return head;

        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        while(ptr2 != null && ptr2.next != null) {
            ptr2 = ptr2.next.next;
            ptr1 = ptr1.next;
        }

        ptr2 = ptr1.next;
        ptr1.next = null;
        ptr1 = sortList(ptr2);
        ptr2 = sortList(head);

        ListNode res = null;
        ListNode prev = null;

        while(ptr1 != null && ptr2 != null) {
            ListNode curr = null;
            
            if(ptr1.val <= ptr2.val) {
                curr = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr = ptr2;
                ptr2 = ptr2.next;
            }

            if(res == null) {
                res = curr;
                prev = curr;
            }
            else {
                prev.next = curr;
                prev = curr;
            }
        }

        prev.next = (ptr1 == null) ? ptr2 : ptr1;

        return res;
    }
}