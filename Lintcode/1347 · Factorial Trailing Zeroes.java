public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int trailingZeroes(int n) {
        // write your code here
        if (n < 5) {
          return 0;
        } else {
          return n / 5 + trailingZeroes(n / 5);
        }

    }
}
