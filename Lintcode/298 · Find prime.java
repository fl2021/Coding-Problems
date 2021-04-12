public class Solution {
    /**
     * @param n: an integer
     * @return: return all prime numbers within n.
     */
    public List<Integer> prime(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n == 0 || n == 1) {
          return res;
        }
        for (int j = 2; j <= n; j++) {
          if (isPrime(j)) {
            res.add(j);
          }                   
        }
      return res;
   }

    private boolean isPrime(int n) {
      for (int j = 2; j < n; j++) {
             if (n % j == 0) {
             return false;
            }
        }
        return true;
    }
}