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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode();
        ListNode prev = head;

        while(l1 != null || l2 != null) {
            int num1 = 0;
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            int num2 = 0;
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            num1 += num2 + ((carry) ? 1 : 0);
            carry = (num1>=10);
            num1 %= 10;

            prev.next = new ListNode(num1);
            prev = prev.next;
        }

        if(carry) prev.next = new ListNode(1);

        return head.next;
    }
}