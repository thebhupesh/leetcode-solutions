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
            if(res2 == null) {
                prev.next = res1;
                prev = res1;
                
                res1 = res1.next;
            } else if(res1 == null) {
                prev.next = res2;
                prev = res2;

                res2 = res2.next;
            } else if(res1.val <= res2.val) {
                if(res == null) {
                    res = res1;
                    prev = res1;
                }
                else {
                    prev.next = res1;
                    prev = res1;
                }

                res1 = res1.next;
            } else {
                if(res == null) {
                    res = res2;
                    prev = res2;
                }
                else {
                    prev.next = res2;
                    prev = res2;
                }

                res2 = res2.next;
            }
        }

        return res;
    }
}