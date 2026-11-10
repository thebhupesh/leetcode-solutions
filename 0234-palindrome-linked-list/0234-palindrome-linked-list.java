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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        boolean checkRev = false;

        while(ptr1 != null) {
            if(!checkRev) {
                ListNode temp = ptr1.next;
                ptr1.next = prev;
                prev = ptr1;
                ptr1 = temp;
                
                if(ptr2 == null || ptr2.next == null) {
                    checkRev = true;
                    
                    ptr1 = prev;
                    if(ptr2 == null) ptr1 = ptr1.next;
                    
                    ptr2 = temp;
                }
                else ptr2 = ptr2.next.next;
            } else {
                if(ptr1.val != ptr2.val) return false;

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        return true;
    }
}