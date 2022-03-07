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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        // pointing to dummy so that we can remove head when it's val is equal to given val in the function
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val!= val) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        //if the head.val == val, we will remove the head, so should return dummy.next
        return dummy.next;
        
    }
}