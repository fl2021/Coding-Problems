public class MyQueue {
    /*
     * @param item: An integer
     * @return: nothing
     */
    private ListNode head;
    private ListNode tail;
    public MyQueue() {
        head = tail = null;
    }
    
    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            tail = new ListNode(item);
            head = tail;
        } else {
            tail.next = new ListNode(item);
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head != null) {
            int value = head.val;
            head = head.next;
            return value;
        }
        return -1;
    }
}

class ListNode { 
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

