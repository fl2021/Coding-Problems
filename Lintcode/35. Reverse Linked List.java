/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while ( head != null) {
            ListNode temp = head.next;
            head.next = pre;
            temp.next = head;
        }
    }
}
考虑head是不是null的情况
对list进行遍历，重新排序。