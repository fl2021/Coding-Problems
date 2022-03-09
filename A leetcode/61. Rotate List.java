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
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(head);

        n = n % length;
        ListNode ahead = dummy;
        for (int i = 0; i < n; i++) {
            ahead = ahead.next;
        }
       ListNode behind = dummy;
        while (ahead.next!= null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        ahead.next = dummy.next;
        dummy.next = behind.next;
        behind.next = null;
        return dummy.next;
        
    }
}
//Time : O(N)
//Space: O(1)