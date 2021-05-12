public class Solution {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    public long doubleFactorial(int n) {
        // Write your code here
        if (n == 1 || n == 2) {
          return n;
        }
        return n * doubleFactorial(n - 2);
    }
}