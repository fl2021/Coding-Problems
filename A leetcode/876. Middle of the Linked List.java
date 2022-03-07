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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //fast的条件一定要放在前面，不然会错误的，因为判断是有顺序的。
        //先自己演练一遍可以确定condition
        while (fast!= null && fast.next!= null ) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        return slow;
        
    }
}