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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;

        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        while(n > 1) {
            curr = stack.pop();
            n--;
        }

        stack.pop();

        if(stack.size() == 0) return curr;
        
        stack.peek().next = curr;
        return head;
    }
}