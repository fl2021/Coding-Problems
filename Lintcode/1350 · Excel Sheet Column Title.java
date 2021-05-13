public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        StringBuilder str = new StringBuilder();
        
        while (n > 0) {
          n--;
          str.append((char)('A' + n % 26 ));
          n = n / 26;
        }
      
        return str.reverse().toString();
    }
}