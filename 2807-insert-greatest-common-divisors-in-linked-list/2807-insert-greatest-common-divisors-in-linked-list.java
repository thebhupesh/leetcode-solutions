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
    private int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;

        while(prev.next != null) {
            ListNode curr = prev.next;
            ListNode node = new ListNode(gcd(prev.val,curr.val),curr);
            prev.next = node;
            prev = curr;
        }

        return head;
    }
}