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

        ListNode ptr = head;
        ListNode fastPtr = head.next;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            ptr = ptr.next;
        }

        ListNode res1 = sortList(ptr.next);
        ptr.next = null;
        ListNode res2 = sortList(head);
        ListNode res = null;
        ListNode prev = null;

        while(res1 != null || res2 != null) {
            ListNode curr = null;
            
            if(res2 == null) {
                prev.next = res1;
                break;
            } else if(res1 == null) {
                prev.next = res2;
                break;
            } else if(res1.val <= res2.val) {
                curr = res1;
                res1 = res1.next;
            } else {
                curr = res2;
                res2 = res2.next;
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

        return res;
    }
}