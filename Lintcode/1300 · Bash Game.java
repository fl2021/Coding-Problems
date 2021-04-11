public class Solution {
    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */
    public boolean canWinBash(int n) {
        // Write your code here
        if (n % 4 == 0) {
          return false;
        }
        return true;
    }
}