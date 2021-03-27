public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        // do intialization if necessary
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        } 
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int num = stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }    
        return num;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}

//stack: 7,8,6,9
//minStack: 7,7,6,6

//isEmpty();
//pop();
//peek();
//stack: 4 2 2 3 
//minStack: 4 2 2 