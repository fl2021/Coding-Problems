public class MyQueue {
 
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
        
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    private void move() {
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
    }
   
    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            move();
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            move();
        }
        return stack2.peek();
    }
}
