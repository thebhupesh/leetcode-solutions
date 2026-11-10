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
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        boolean check = false;
        List<Integer> nums = new ArrayList<>();
        int pos = 0;

        while(ptr1 != null) {
            if(check && ptr1.val != nums.get(--pos)) return false;
            else if(!check) {
                nums.add(ptr1.val);

                if(ptr2 == null || ptr2.next == null) {
                    check = true;
                    pos = nums.size();
                    if(ptr2 == null) pos--;
                }
                else ptr2 = ptr2.next.next;
            }
            
            ptr1 = ptr1.next;
        }

        return true;
    }
}