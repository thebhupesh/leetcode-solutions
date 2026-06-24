/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1 == ptr2) {
                return true;
            }

            ptr1 = ptr1.next;
            if(ptr2.next != null) {
                ptr2 = ptr2.next.next;
            } else {
                break;
            }
        }

        return false;
    }
}