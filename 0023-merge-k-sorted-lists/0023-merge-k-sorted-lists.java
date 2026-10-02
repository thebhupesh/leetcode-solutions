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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;

        int len = lists.length;
        boolean hasElement = true;

        while(len > 0) {
            hasElement = false;
            ListNode temp = null;
            int pos = 0;

            for(int i=0; i<len; i++) {
                if(lists[i] != null) {
                    hasElement = true;
                    if(temp == null || temp.val > lists[i].val) {
                        temp = lists[i];
                        pos = i;
                    }
                }
            }

            if(!hasElement) break;

            if(head == null) {
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = temp;
            }

            lists[pos] = lists[pos].next;
        }

        return head;
    }
}