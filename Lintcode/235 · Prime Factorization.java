public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> prime = new ArrayList<Integer>();
        for (int i = 2; i * i <= num; i++) {
          while (num % i == 0) {
            num = num / i;
            prime.add(i);
          }
        }
        if (num != 1) {
          prime.add(num);
        }
        return prime;
    }
}