public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
     ArrayList<Integer> array = new ArrayList<Integer>();
    public void push(int x) {
        // write your code here
        array.add(x);
        
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        int n = array.size();
        if (n > 0)
        array.remove(n-1);
        return;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int n = array.size();
        return array.get(n-1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return array.size() == 0;
    }
}