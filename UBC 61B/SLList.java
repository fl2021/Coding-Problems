/*An SLList is a list of integers, which hides the terrible truth of the nakedness within

*/
public class SLList {
    public static void main(String[] args) {
        public IntNode first;

        public SLList(int x) {
            first = new IntNode(x, null);
        }

        public static void main(String[] args) {
            /*Create a list of one integer, namely 10 */
            SLList L = new SLList(10);
        }

    }
}

//improvement #2 bureaucracy
public class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n) {
        item = i;
        next = n;
    }
}